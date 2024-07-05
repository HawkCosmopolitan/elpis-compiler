package tra.v7;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Node implements Serializable, Cloneable {
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
    public String name;
    public ArrayList<Tuple<String, Node, Boolean, String, Node, Action[]>> nextTable;
    public Node(String name) {
        this.name = name;
        this.nextTable = new ArrayList<>();
    }
    public Node addRule(String trigger, Node next, Action action) {
        this.nextTable.add(new Tuple<>(trigger, next, true, "", null, new Action[]{action}));
        return this;
    }
    public Node joinRule(Node next, Action action, String trigger, Node nextNext, Action action2) {
        this.nextTable.add(new Tuple<>("", next, false, trigger, nextNext, new Action[]{action, action2}));
        return this;
    }
    public boolean hasNop() {
        HashSet<String> cache = new HashSet<>();
        return this.hasNopInternal(cache);
    }
    private boolean hasNopInternal(HashSet<String> prevs) {
        if (prevs.contains(this.name)) {
            return true;
        }
        System.out.println(this.nextTable.stream().map(s -> s.a).toList());
        for (Tuple<String, Node, Boolean, String, Node, Action[]> next : this.nextTable) {
            System.out.println("__ " + this.name + " " + next.a + " __");
            if (next.c) {
                if (next.a.equals("$nop")) {
                    if (next.b == null) {
                        return true;
                    } else {
                        if (prevs.contains(next.b.name)) {
                            return true;
                        } else {
                            prevs.add(next.b.name);
                            return next.b.hasNopInternal(prevs);
                        }
                    }
                }
            }
        }
        return false;
    }
}
