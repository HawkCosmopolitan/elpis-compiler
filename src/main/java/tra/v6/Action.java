package tra.v6;

import java_cup.runtime.Symbol;

import java.io.Serializable;
import java.util.Hashtable;

public interface Action extends Serializable {

    public Object act(Hashtable<String, Object> cache, Symbol arg);
}
