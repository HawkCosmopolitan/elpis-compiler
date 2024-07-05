package tra.v6;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java_cup.runtime.Symbol;
import tra.helpers.JsonHelper;
import tra.models.Codes;
import tra.models.FileDeps;
import tra.models.sym;
import tra.models.temp.Path;
import tra.models.temp.Point;

import java.io.*;
import java.util.*;

public class ElpisParser implements Serializable {
    private Node tree;
    private ElpisLexer lexer;
    private Symbol[] tokens;
    private Stack<Hashtable<String, Object>> stack;
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
                    token.sym = tra.v6.sym.NEWLINE;
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
        ifNode.joinRule(expNode, new Action() {
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
        }, "start", rootNode, new Action() {
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
                Hashtable<String, Object> old = (Hashtable<String, Object>) cache.get("old");
                Hashtable<String, Object> newCache = new Hashtable<>();
                ArrayList<Hashtable<String, Object>> body = old.containsKey("body") ?
                        (ArrayList<Hashtable<String, Object>>)old.get("body") :
                        new ArrayList<>();
                body.add((Hashtable<String, Object>) old.get("exp"));
                newCache.put("body", body);
                return newCache;
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
                ArrayList<Hashtable<String, Object>> body = (ArrayList<Hashtable<String,java.lang.Object>>)old.get("body");
                body.add((Hashtable<String, Object>)cache.get("exp"));
                newCache.put("body", body);
                return newCache;
            }
        });
        this.tree = rootNode;
    }
    boolean error = false;
    boolean matched = false;
    void iterate(Node node, int index) {
        print("forward");
        Symbol token = tokens[index];
        if (token.value == null) {
            if (node == null) {
                matched = true;
            } else {
                if (!node.hasNop()) {
                    error = true;
                    matched = false;
                } else {
                    matched = true;
                }
            }
            return;
        }
        if (history.containsKey(node.name + ":" + index)) {
            return;
        }
        this.history.put(node.name + ":" + index, new Hashtable<>());
        for (Tuple<String, Node, Boolean, String, Node, Action[]> next : node.nextTable) {
            if (!next.c) {
                print("auto-node , " + next.b.name);
                this.stack.push(new Hashtable<>());
                ArrayList<String> arr = new ArrayList<>();
                boolean nextNextAvailable = (next.e != null);
                if (nextNextAvailable) {
                    for (Tuple<String, Node, Boolean, String, Node, Action[]> nextNext : node.nextTable) {
                        arr.add(nextNext.a);
                    }
                    this.nodeStack.push(new Tuple<>(next.b, next.d, arr.toArray(new String[]{}), next.e, next.f[1], true));
                }
                print("1 " + node.name + " " + next.b.name);
                iterate(next.b, index);
                if (nextNextAvailable) this.nodeStack.pop();
                Hashtable<String, Object> cache = this.stack.pop();
                if (!cache.containsKey("old")) {
                    cache.put("old", new Hashtable<>());
                }
                Hashtable<String, Object> subCache = (Hashtable<String, Object>) next.f[0].act(cache, token);
                this.stack.peek().put("old", subCache);
                for (int i = nodeStack.size() - 1; i >= 0; i--) {
                    if (nodeStack.get(i).a.name.equals(node.name)) {
                        if (nodeStack.get(i).f) {

                        }
                        break;
                    }
                }
                if (matched || error) {
                    return;
                }
            } else {
                print("comparing : " + token.value + ", " + next.a + " in " + node.name);
                if (
                        (sym.terminalNames[token.sym].equals("word") && token.value.equals(next.a)) ||
                                sym.terminalNames[token.sym].equals(next.a)
                ) {
                    print("matched");
                    this.stack.push(new Hashtable<>());
                    //this.nodeStack.push(new Tuple<>(next.b, "", new String[]{}, null, next.f[0], true));
                    print("2 " + node.name + " " + next.b.name);
                    iterate(next.b, index + 1);
                    //this.nodeStack.pop();
                    Hashtable<String, Object> cache = this.stack.pop();
                    if (!cache.containsKey("old")) {
                        cache.put("old", new Hashtable<>());
                    }
                    Hashtable<String, Object> subCache = (Hashtable<String, Object>) next.f[0].act(cache, token);
                    this.stack.peek().put("old", subCache);
                    if (matched || error) {
                        return;
                    }
                } else {
                    print("did not match");
                }
            }
        }
        print("checking join rules....");
        if (node.hasNop()) {
            for (int i = nodeStack.size() - 1; i >= 0; i--) {
                if (nodeStack.get(i).a.hasNop()) {
                    if (Arrays.stream(nodeStack.get(i).c).anyMatch(s -> (s.equals(token.value) || s.equals(sym.terminalNames[token.sym]))) ||
                    nodeStack.get(i).b.equals(token.value) || nodeStack.get(i).b.equals(sym.terminalNames[token.sym])) {
                        print("matched by a join rule");
                        this.stack.push(new Hashtable<>());
                        ArrayList<String> arr = new ArrayList<>();
                        if (nodeStack.get(i).d != null) {
                            for (Tuple<String, Node, Boolean, String, Node, Action[]> next : nodeStack.get(i).d.nextTable) {
                                arr.add(next.a);
                            }
                        }
                        Action action;
                        boolean isEntry;
                        if (nodeStack.get(i).b.equals(token.value) || nodeStack.get(i).b.equals(sym.terminalNames[token.sym])) {
                            isEntry = true;
                            action = nodeStack.get(i).e;
                        } else {
                            isEntry = false;
                            action = new Action() {
                                @Override
                                public Object act(Hashtable<String, Object> cache, Symbol arg) {
                                    print(cache);
                                    Hashtable<String, Object> newCache = new Hashtable<>();
                                    newCache.put("old", cache);
                                    return newCache;
                                }
                            };
                        }
                        this.nodeStack.push(new Tuple<>(nodeStack.get(i).d, "", arr.toArray(new String[]{}), nodeStack.get(i).d, action, isEntry));
                        print("3 " + nodeStack.get(i).d.name + " " + nodeStack.get(i).b);
                        iterate(nodeStack.get(i).d, index + 1);
                        this.nodeStack.pop();
                        Hashtable<String, Object> cache = this.stack.pop();
                        if (!cache.containsKey("old")) {
                            cache.put("old", new Hashtable<>());
                        }
                        Hashtable<String, Object> subCache = (Hashtable<String, Object>) action.act(cache, token);
                        this.stack.peek().put("old", subCache);
                        if (matched || error) {
                            return;
                        }
                        break;
                    }
                } else if (nodeStack.get(i).b.equals(token.value) || nodeStack.get(i).b.equals(sym.terminalNames[token.sym]) ||
                        (nodeStack.get(i).b.equals("newline") && token.value.equals("newline"))) {
                    print("matched by a join rule");
                    this.stack.push(new Hashtable<>());
                    ArrayList<String> arr = new ArrayList<>();
                    for (Tuple<String, Node, Boolean, String, Node, Action[]> next : nodeStack.get(i).d.nextTable) {
                        arr.add(next.a);
                    }
                    Action action;
                    boolean isEntry;
                    if (nodeStack.get(i).b.equals(token.value) || nodeStack.get(i).b.equals(sym.terminalNames[token.sym])) {
                        isEntry = true;
                        action = nodeStack.get(i).e;
                    } else {
                        isEntry = false;
                        action = new Action() {
                            @Override
                            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                                print(cache);
                                Hashtable<String, Object> newCache = new Hashtable<>();
                                newCache.put("old", cache);
                                return newCache;
                            }
                        };
                    }
                    this.nodeStack.push(new Tuple<>(nodeStack.get(i).d, "", arr.toArray(new String[]{}), nodeStack.get(i).d, action, isEntry));
                    print("4 " + nodeStack.get(i).d.name + " " + nodeStack.get(i).b);
                    iterate(nodeStack.get(i).d, index + 1);
                    this.nodeStack.pop();
                    Hashtable<String, Object> cache = this.stack.pop();
                    if (!cache.containsKey("old")) {
                        cache.put("old", new Hashtable<>());
                    }
                    Hashtable<String, Object> subCache = (Hashtable<String, Object>) action.act(cache, token);
                    this.stack.peek().put("old", subCache);
                    if (matched || error) {
                        return;
                    }
                    break;
                }
            }
        }
    }
    public void parse() {

        Node current = this.tree;
        this.stack.push(new Hashtable<>());
        this.nodeStack.push(new Tuple<>(current, "newline", new String[]{}, current, new Action() {
            @Override
            public Object act(Hashtable<String, Object> cache, Symbol arg) {
                print(cache);
                Hashtable<String, Object> newCache = new Hashtable<>();
                newCache.put("old", cache);
                return newCache;

            }
        }, true));
        iterate(current, 0);
        if (matched) {
            print("success !");
        } else {
            print("failure.");
        }
    }
}
