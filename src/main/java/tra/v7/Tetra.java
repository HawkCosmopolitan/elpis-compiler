package tra.v7;

import java.io.Serializable;

public class Tetra<A, B, C, D> implements Serializable {

    public A a;
    public B b;
    public C c;
    public D d;

    public Tetra(A a, B b, C c, D d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
}
