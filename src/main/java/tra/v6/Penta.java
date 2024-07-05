package tra.v6;

import java.io.Serializable;

public class Penta<A, B, C, D, E> implements Serializable {

    public A a;
    public B b;
    public C c;
    public D d;
    public E e;

    public Penta(A a, B b, C c, D d, E e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }
}
