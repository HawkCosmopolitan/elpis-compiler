package tra.v6;

import java.io.Serializable;

public class Tuple<A, B, C, D, E, F> implements Serializable {

    public A a;
    public B b;
    public C c;
    public D d;
    public E e;
    public F f;

    public Tuple(A a, B b, C c, D d, E e, F f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
}
