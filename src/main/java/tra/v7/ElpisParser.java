package tra.v7;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java_cup.runtime.Symbol;
import tra.helpers.JsonHelper;
import tra.models.sym;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class ElpisParser implements Serializable {
    private Node tree;
    private ElpisLexer lexer;
    private Symbol[] tokens;
    private Stack<Node> stack;
    private Stack<Tuple<Node, String, String[], Node, Action, Boolean>> nodeStack;
    private Hashtable<String, Hashtable<String, Object>> history;
    private void print(Object obj) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(JsonHelper.toJson(obj));
        String buildTree = gson.toJson(je);
        System.out.println(buildTree);
    }
    public ElpisParser(ElpisLexer lexer) {
        this.lexer = lexer;
        this.stack = new Stack<>();
        this.nodeStack = new Stack<>();
        this.history = new Hashtable<>();
        HashSet<String> reservedWords = new HashSet<>();
        for (int counter = 0; counter < sym.terminalNames.length; counter++) {
            if (sym.terminalNames[counter].toLowerCase().equals("empty")) continue;
            if (sym.terminalNames[counter].toLowerCase().equals("end")) continue;
            if (sym.terminalNames[counter].toLowerCase().equals("start")) continue;
            sym.terminalNames[counter] = sym.terminalNames[counter].toLowerCase();
            reservedWords.add(sym.terminalNames[counter]);
        }
        ArrayList<Symbol> tokenList = new ArrayList<>();
        Symbol token;
        try {
            while ((token = this.lexer.next_token()).value != null) {
                if (token.sym != sym.STRING && token.value instanceof String) {
                    token.value = ((String) token.value).trim();
                }
                if (token.value instanceof String) {
                    try {
                        token.value = Short.parseShort((String) token.value);
                        token.sym = sym.NUMBER;
                    } catch (Exception ex1) {
                        try {
                            token.value = Integer.parseInt((String) token.value);
                            token.sym = sym.NUMBER;
                        } catch (Exception ex2) {
                            try {
                                token.value = Long.parseLong((String) token.value);
                                token.sym = sym.NUMBER;
                            } catch (Exception ex3) {
                                try {
                                    token.value = Float.parseFloat((String) token.value);
                                    token.sym = sym.NUMBER;
                                } catch (Exception ex4) {
                                    try {
                                        token.value = Double.parseDouble((String) token.value);
                                        token.sym = sym.NUMBER;
                                    } catch (Exception ex5) {
                                        if (token.sym != sym.START && token.sym != sym.END) {
                                            if (!reservedWords.contains((String) token.value)) {
                                                token.sym = sym.IDENTIFIER;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (sym.terminalNames[token.sym].equals("START")) token.value = "start";
                if (sym.terminalNames[token.sym].equals("END")) token.value = "end";
                if (sym.terminalNames[token.sym].equals("EMPTY")) token.value = "empty";
                if (token.value.equals("")) {
                    token.sym = tra.v7.sym.NEWLINE;
                    token.value = "newline";
                }
                tokenList.add(token);
                System.out.println(sym.terminalNames[token.sym] + " " + token.value);
            }
            tokenList.add(new Symbol(sym.EOF, 0, 0, null));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        this.tokens = tokenList.toArray(new Symbol[0]);

        Node rootNode = new Node("root");
        Node expNode = new Node("exp");
        Node expAfOp = new Node("expAfOp");
        Node expOp = new Node("expOp");
        expOp.addRule("$nop", null, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                newCache.put("old", cache);
                return newCache;
            }
        });
        expOp.addRule("+", expAfOp, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                Hashtable<String, Object> old = ((Hashtable<String, Object>)cache.get("old"));
                newCache.put("operand2", old.get("operand2"));
                newCache.put("operator", "+");
                return newCache;
            }
        });
        expOp.addRule("==", expAfOp, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                Hashtable<String, Object> old = ((Hashtable<String, Object>)cache.get("old"));
                newCache.put("operand2", old.get("operand2"));
                newCache.put("operator", "==");
                return newCache;
            }
        });
        expNode.addRule("$nop", null, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                newCache.put("old", cache);
                return newCache;
            }
        });
        expNode.addRule("number", expOp, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                Hashtable<String, Object> exp = new Hashtable<>();
                Hashtable<String, Object> old = ((Hashtable<String, Object>)cache.get("old"));
                exp.put("operand2", old.get("operand2"));
                exp.put("operator", old.get("operator"));
                exp.put("operand1", arg.value);
                newCache.put("exp", exp);
                return newCache;
            }
        });
        expAfOp.addRule("number", expOp, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                newCache.put("operand2", arg.value);
                return newCache;
            }
        });
        Node ifNode = new Node("if");
        Node ifBodyNode = new Node("ifBody");
        ifNode.joinRule(expNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                Hashtable<String, Object> newCache  = new Hashtable<>();
                newCache.put("condition", cache.get("old"));
                return newCache;
            }
        }, "start", ifBodyNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print("+++++++++");
                print(cache);
                print("+++++++++");
                Hashtable<String, Object> newCache  = new Hashtable<>();
                newCache.put("condition", cache.get("old"));
                newCache.put("body", cache);
                return newCache;
            }
        });
        Node ifBodyEndNode = new Node("ifBodyEndNode");
        ifBodyNode.joinRule(rootNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                return cache;
            }
        }, "end", ifBodyEndNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                return cache;
            }
        });
        ifBodyEndNode.addRule("$nop", null, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                return cache;
            }
        });
        rootNode.addRule("newline", rootNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> old = (Hashtable<String, Object>)cache.get("old");
                Hashtable<String, Object> newCache = new Hashtable<>();
                ArrayList<Hashtable<String, Object>> body = (ArrayList<Hashtable<String, Object>>)old.get("body");
                body.add((Hashtable<String, Object>)cache.get("exp"));
                newCache.put("body", body);
                return newCache;
            }
        });
        rootNode.addRule("end", rootNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> old = (Hashtable<String, Object>)cache.get("old");
                Hashtable<String, Object> newCache = new Hashtable<>();
                ArrayList<Hashtable<String, Object>> body = (ArrayList<Hashtable<String, Object>>)old.get("body");
                body.add((Hashtable<String, Object>)cache.get("exp"));
                newCache.put("body", body);
                return newCache;
            }
        });
        rootNode.addRule("$nop", null, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                newCache.put("old", cache);
                return newCache;
            }
        });
        rootNode.joinRule(expNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                return cache;
            }
        }, "$nop", null, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                Hashtable<String, Object> old = (Hashtable<String, Object>) cache.get("old");
                Hashtable<String, Object> newCache = new Hashtable<>();
                ArrayList<Hashtable<String, Object>> body = old.containsKey("body") ?
                        (ArrayList<Hashtable<String, Object>>)old.get("body") :
                        new ArrayList<>();
                body.add((Hashtable<String, Object>) old.get("exp"));
                newCache.put("body", body);
                return newCache;
            }
        });
        rootNode.addRule("if", ifNode, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                newCache.put("old", cache);
                return newCache;
            }
        });
        this.tree = rootNode;
    }
    boolean error = false;
    boolean matched = false;
    Stack<Pair<Node, String>> steps = new Stack<>();
    int iterate(Node node, int index, boolean isExitingRule, Node prevNode) {
        print("forward " + (node == null ? "null" : node.name) + " " + tokens[index].value + " " + index);
        print("steps: " + this.steps.stream().map(s -> s.a.name).toList());
        Symbol token = tokens[index];
        if (token.value == null) {
            if (node == null) {
                matched = true;
            } else {
                print("checking last nop... " + node.name + " " + node.hasNop());
                if (!node.hasNop()) {
                    error = true;
                    matched = false;
                } else {
                    matched = true;
                }
            }
            return 0;
        }
        if (node == null) {
            if (tokens[index + 1].value == null) {
                boolean foundEnd = false;
                print("the last : " + prevNode.name);
                for (Tuple<String, Node, Boolean, String, Node, Action[]> next : prevNode.nextTable) {
                    if (next.a.equals("end") || next.d.equals("end")) {
                        foundEnd = true;
                        break;
                    }
                }
                if (foundEnd) {
                    matched = true;
                    return 0;
                }
            }
        }
        if (history.containsKey(node.name + ":" + index)) {
            return 0;
        }
        this.history.put(node.name + ":" + index, new Hashtable<>());
        print(node.nextTable.stream().map(s -> (s.b != null ? s.b.name : "")).toList());
        for (Tuple<String, Node, Boolean, String, Node, Action[]> next : node.nextTable) {
            if (next.c) {
                    print("is c " + next.a);
                    if (next.a.equals("$nop")) {
                        if (next.b == null && next.e == null) {
                            if (tokens[index + 1].value == null) {
                                boolean foundEnd = false;
                                print("the last : " + prevNode.name);
                                for (Tuple<String, Node, Boolean, String, Node, Action[]> n : prevNode.nextTable) {
                                    if (n.a.equals("end") || n.d.equals("end")) {
                                        foundEnd = true;
                                        break;
                                    }
                                }
                                if (foundEnd) {
                                    matched = true;
                                    return 0;
                                }
                            }
                        }
                    } else if (
                            (sym.terminalNames[token.sym].equals("word") && token.value.equals(next.a)) ||
                                    (sym.terminalNames[token.sym].equals("START") && next.a.equals("start")) ||
                                    (sym.terminalNames[token.sym].equals("END") && next.a.equals("end")) ||
                                    sym.terminalNames[token.sym].equals(next.a)
                    ) {
                        print("comparing in " + next.b.name + " -- [" + token.value + "] , [" + next.a + "]");
                        this.stack.push(next.b);
                        iterate(next.b, index + 1, false, node);
                        this.stack.pop();
                        if (matched || error) return 0;
                    }
            } else {
                print(isExitingRule);
                if (isExitingRule) {
                    if (
                            (sym.terminalNames[token.sym].equals("word") && token.value.equals(next.d)) ||
                            (sym.terminalNames[token.sym].equals("START") && next.d.equals("start")) ||
                            (sym.terminalNames[token.sym].equals("END") && next.d.equals("end")) ||
                            sym.terminalNames[token.sym].equals(next.d)
                    ) {
                        iterate(next.e, index + 1, false, node);
                    }
                } else {
                    print("auto-node " + next.b.name + " " + node.name);
                    this.steps.push(new Pair<>(node, next.d));
                    this.stack.push(next.b);
                    iterate(next.b, index, false, node);
                    this.stack.pop();
                    if (matched || error) return 0;
                }
            }
        }
        print("looking at stack... " + this.steps.size());
        print("............................");
        String stackNodeName = null;
        String stackNodePlusName = null;

        if (!node.hasNop()) {
            return 0;
        }

        for (int i = this.stack.size() - 1; i >= 0; i--) {
            final Node n = this.stack.get(i);
            stackNodePlusName = n.name;
            if (this.steps.stream().anyMatch(s -> s.a.name.equals(n.name))) {
                print("found in stack");
                break;
            }
            stackNodeName = n.name;
            print("checking " + stackNodeName);
        }
        print(stackNodeName);

        print("printing steps... " + this.steps.stream().map(s -> s.a.name).toList());

        for (int i = this.steps.size() - 1; i >= 0; i--) {
            Pair<Node, String> step = this.steps.get(i);
            print("looking at step : " + step.a.name + " | [" + token.value + "] " +
                    Arrays.toString(step.a.nextTable.stream().map(s -> s.d).toArray()) + " " +
                    Arrays.toString(step.a.nextTable.stream().map(s -> s.a).toArray()));
            if (step.a.hasNop()) {
                print(step.a.name + " has nop");
                boolean isFirst = step.a.nextTable.stream().anyMatch(s -> ((s.c && s.a.equals(token.value))));
                boolean isSecond = step.a.nextTable.stream().anyMatch(s -> ((!s.c && s.d.equals(token.value))));
                print(isFirst + " " + isSecond + " " + step.a.name + " " + stackNodeName);
                if (step.a.name.equals(stackNodePlusName) && (isFirst || isSecond)) {
                    if (isFirst) {
                        Node theNextNode = step.a.nextTable.stream().filter(s -> ((s.c && s.a.equals(token.value)))).findFirst().get().b;
                        this.stack.push(theNextNode);
                        iterate(theNextNode, index + 1, false, node);
                        this.stack.pop();
                    } else {
                        this.stack.push(step.a);
                        iterate(step.a, index + 1, false, node);
                        this.stack.pop();
                    }
                    if (matched || error) return 0;
                    break;
                } else {
                    if (i == 0) return 0;
                    stackNodePlusName = stackNodeName;
                    stackNodeName = this.steps.get(i - 1).a.name;
                }
            } else {
                if (step.a.name.equals(stackNodeName) && step.a.nextTable.stream().anyMatch(s -> ((s.c && s.a.equals(token.value)) || (!s.c && s.d.equals(token.value))))) {
                    print("hello 1");
                    this.stack.push(step.a);
                    iterate(step.a, index + 1, false, node);
                    this.stack.pop();
                    if (matched || error) return 0;
                    break;
                } else {
                    print("hello 2");
                    Node foundNode = null;
                    for (Tuple<String, Node, Boolean, String, Node, Action[]> next : this.steps.get(i).a.nextTable) {
                        print("last chances: " + sym.terminalNames[token.sym] + " d: [" + next.d + "] [" + stackNodeName + "]");
                        if (
                                (sym.terminalNames[token.sym].equals("word") && token.value.equals(next.d)) ||
                                        (sym.terminalNames[token.sym].equals("START") && next.d.equals("start")) ||
                                        (sym.terminalNames[token.sym].equals("END") && next.d.equals("end")) ||
                                        sym.terminalNames[token.sym].equals(next.d)
                        ) {
                            print("ok");
                            if (stackNodeName.equals(next.b.name)) {
                                foundNode = next.e;
                                break;
                            }
                        }
                        print("last chances: " + sym.terminalNames[token.sym] + " b: [" + next.a + "] [" + stackNodeName + "]");
                        if (
                                (sym.terminalNames[token.sym].equals("word") && token.value.equals(next.a)) ||
                                        (sym.terminalNames[token.sym].equals("START") && next.a.equals("start")) ||
                                        (sym.terminalNames[token.sym].equals("END") && next.a.equals("end")) ||
                                        sym.terminalNames[token.sym].equals(next.a)
                        ) {
                                print("ok " + stackNodePlusName + " " + next.b.name);
                                    foundNode = next.b;
                                    break;
                        }
                    }
                    if (foundNode != null) {
                        this.stack.push(foundNode);
                        print("foundNode: " + foundNode.name);
                        iterate(foundNode, index + 1, false, node);
                        this.stack.pop();
                        if (matched || error) return 0;
                        break;
                    } else {
                        print("hello 3");
                        this.steps.pop();
                        print("printing steps after pop... " + this.steps.stream().map(s -> s.a.name).toList());
                        iterate(this.steps.peek().a, index, true, node);
                        return 1;
                    }
                }
            }
        }
        print("............................");
        return 0;
    }
    public void parse() {

        Node current = this.tree;
        this.steps.push(new Pair<>(current, "newline"));
        this.stack.push(current);
        iterate(current, 0, false, null);
        if (matched) {
            print("success !");
        } else {
            print("failure.");
        }
    }
}
