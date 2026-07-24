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

    /**
    * Rimuove tutte le coppie chiave-valore dalla mappa.
    */
    void clear();

    /**
    * Restituisce un HSet che è una vista delle chiavi presenti in questa mappa. Le modifiche alla mappa si riflettono nell'HSet e viceversa.
    * Se la mappa viene modificata mentre si itera sull'HSet, il comportamento dell'iteratore è indefinito. Non supporta add e addAll.
    *
    * @return un HSet che è una vista delle chiavi presenti in questa mappa.
    */
    HSet keySet();

    /**
    * Restituisce un HCollection che è una vista dei valori presenti in questa mappa. Le modifiche alla mappa si riflettono nell'HCollection e 
    * viceversa. Se la mappa viene modificata mentre si itera sull'HCollection, il comportamento dell'iteratore è indefinito. 
    * Non supporta add e addAll.
    * 
    * @return un HCollection che è una vista dei valori presenti in questa mappa.
    */
    HCollection values();

    /**
    * Restituisce un HSet che è una vista delle coppie chiave-valore presenti in questa mappa. Le modifiche alla mappa 
    * si riflettono nell'HSet e viceversa. Se la mappa viene modificata mentre si itera sull'HSet, il comportamento dell'iteratore 
    * è indefinito. Non supporta add e addAll.
    * 
    * @return un HSet che è una vista delle coppie chiave-valore presenti in questa mappa.
    */
    HSet entrySet();

    /**
    * Compara l'oggetto specificato con questa mappa per verificare se sono uguali. Due mappe sono considerate uguali se contengono 
    * le stesse coppie chiave-valore.
    *
    * @param o l'oggetto da confrontare con questa mappa.
    * @return true se l'oggetto è uguale a questa mappa.
    */
    boolean equals(Object o);

    /**
    * Restituisce il codice hash di questa mappa. Il codice hash è calcolato come la somma del codice hash delle entry della mappa.
    *
    * @return il codice hash di questa mappa.
    */
    int hashCode();

    /**
     * Rappresenta un'associazione chiave-valore contenuta in una mappa.
     */
    public static interface Entry {

        /**
         * Restituisce la chiave di questa associazione.
         *
         * @return la chiave dell'associazione
         */
        Object getKey();

        /**
         * Restituisce il valore di questa associazione.
         *
         * @return il valore associato alla chiave
         */
        Object getValue();

        /**
         * Sostituisce il valore associato alla chiave con quello specificato. il valore viene modificato anche nella mappa che contiene 
         * questa entry.
         *
         * @param value il nuovo valore da associare alla chiave
         * @return il valore precedentemente associato alla chiave
         * @throws NullPointerException se {@code value} è {@code null}
         */
        Object setValue(Object value);

        /**
         * Confronta questa entry con l'oggetto specificato. Due entry sono considerate uguali se hanno chiavi e valori equivalenti.
         *
         * @param obj l'oggetto da confrontare
         * @return {@code true} se l'oggetto è uguale a questa entry
         */
        boolean equals(Object obj);

        /**
         * Restituisce il codice hash dell'entry. L'hash code è calcolato come key.hashCode() ^ value.hashCode(), dove key e value 
         * sono la chiave e il valore dell'entry entrambi non nulli.
         *
         * @return l'hash code dell'entry
         */
        int hashCode();
    }
}