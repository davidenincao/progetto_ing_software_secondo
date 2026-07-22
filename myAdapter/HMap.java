package myAdapter;

/**
 * Interfaccia HMap che replica interamente l'interfaccia java.util.HMap
 * della versione J2SE 1.4.2
 */
public interface HMap {

    /**
    * Restituisce il numero di coppie chiave-valore presenti nella mappa.
    *
    * @return il numero di coppie chiave-valore presenti nella mappa.
    */
    int size();

    /**
    * Restituisce true se la mappa non contiene coppie chiave-valore.
    *
    * @return true se la mappa non contiene coppie chiave-valore.
    */
    boolean isEmpty();

    /**
    * Restituisce true se la mappa contiene la chiave specificata.
    *
    * @param key la chiave di cui verificare la presenza.
    * @return true se la mappa contiene la chiave specificata.
    * @throws NullPointerException se la chiave specificata è null.
    */
    boolean containsKey(Object key);

    /**
    * Restituisce true se almeno una coppia chiave-valore nella mappa contiene il valore specificato.
    *
    * @param value il valore di cui verificare la presenza.
    * @return true se la mappa contiene il valore specificato.
    */
    boolean containsValue(Object value);

    /**
    * Restituisce il valore associato alla chiave specificata. Restituisce null se la chiave non è presente nella mappa. Un valore 
    * null può essere restituito anche se la mappa contiene una coppia chiave-valore con valore null.
    *
    * @param key la chiave del valore da restituire.
    * @return il valore associato alla chiave specificata, o null se la chiave non è presente.
    * @throws NullPointerException se la chiave specificata è null.
    */
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