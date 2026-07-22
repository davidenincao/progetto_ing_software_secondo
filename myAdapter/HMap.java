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
    * @throws NullPointerException se il valore specificato è null.
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

    /**
    * Associa il valore specificato alla chiave specificata. Se la chiave è già presente nella mappa, il valore associato viene sostituito.
    *
    * @param key la chiave a cui associare il valore.
    * @param value il valore da associare alla chiave.
    * @return il valore precedentemente associato alla chiave specificata, o null se la chiave non era presente.
    * @throws NullPointerException se la chiave o il valore specificato sono null.
    */
    Object put(Object key, Object value);

    /**
    * Rimuove la coppia chiave-valore associata alla chiave specificata. Restituisce il valore precedentemente associato alla chiave, 
    * o null se la chiave non era presente.
    *
    * @param key la chiave della coppia chiave-valore da rimuovere.
    * @return il valore precedentemente associato alla chiave specificata, o null se la chiave non era presente.
    * @throws NullPointerException se la chiave specificata è null.
    */
    Object remove(Object key);

    /**
    * Copia tutte le coppie chiave-valore dalla mappa specificata a questa mappa. Se una chiave è già presente, 
    * il valore associato viene sostituito.
    *
    * @param m la mappa da cui copiare le coppie chiave-valore.
    * @throws NullPointerException se la mappa specificata è null o contiene chiavi o valori null.
    */
    void putAll(HMap m);

    void clear();

    HSet keySet();

    HCollection values();

    HSet entrySet();

    boolean equals(Object o);

    int hashCode();
}