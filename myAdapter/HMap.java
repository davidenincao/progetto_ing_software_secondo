package myAdapter;

/**
 * Interfaccia HMap che replica interamente l'interfaccia java.util.HMap
 * della versione J2SE 1.4.2
 */
public interface HMap {
    void clear();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    HSet entrySet();
    boolean equals(Object o);
    Object get(Object key);
    int hashCode();
    boolean isEmpty();
    HSet keySet();
    void put(Object key, Object value);
    void putAll(HMap m);
    Object remove(Object key);
    int size();
    HCollection values();
}