package myAdapter;

/**
 * Interfaccia HMap che replica interamente l'interfaccia java.util.HMap
 * della versione J2SE 1.4.2
 */
public interface HMap {
    /**
     * Restituisce il numero di elementi presenti nella lista.
     *
     * @return il numero di elementi presenti nella lista.
     */
    int size();
    boolean isEmpty();
    boolean containsKey(Object key);
    boolean containsValue(Object value);
    Object get(Object key);
    void put(Object key, Object value);
    Object remove(Object key);
    void putAll(HMap m);
    void clear();
    HSet keySet();
    HCollection values();
    HSet entrySet();
    boolean equals(Object o);
    int hashCode();
}