package myAdapter;

/**
 * Interfaccia HCollection che replica interamente l'interfaccia java.util.Collection
 * della versione J2SE 1.4.2
 */
public interface HCollection {

    /**
    * Restituisce il numero di elementi presenti nella collezione.
    *
    * @return il numero di elementi presenti nella collezione.
    */
    int size();

    /**
    * Restituisce true se la collezione non contiene elementi.
    *
    * @return true se la collezione non contiene elementi.
    */
    boolean isEmpty();

    /**
    * Restituisce true se la collezione contiene l'oggetto specificato.
    *
    * @param o l'oggetto di cui verificare la presenza.
    * @return true se la collezione contiene l'oggetto specificato.
    * @throws NullPointerException se l'oggetto specificato è null.
    */
    boolean contains(Object o);

    HIterator iterator();

    /**
    * Restituisce un array contenente tutti gli elementi della collezione. L'ordine degli elementi nell'array non è garantito.
    *
    * @return un array contenente tutti gli elementi della collezione.
    */
    Object[] toArray();

    /**
    * Restituisce un array contenente tutti gli elementi della collezione. L'ordine degli elementi nell'array non è garantito. 
    * Se l'array specificato è grande abbastanza, gli elementi della collezione vengono inseriti in esso. Altrimenti, viene creato 
    * un nuovo array dello stesso tipo dell'array specificato.
    * 
    * @param a l'array in cui inserire gli elementi della collezione. Se l'array è troppo piccolo, viene creato un nuovo array 
    * della stesso tipo.
    * @return un array contenente tutti gli elementi della collezione.
    */
    Object[] toArray(Object[] a);

    /**
    * Aggiunge l'elemento specificato a questa collezione.
    *
    * @param element l'elemento da aggiungere
    * @return {@code true} se la collezione viene modificata
    * @throws UnsupportedOperationException se l'operazione {@code add} non è supportata da questa collezione
    */
    boolean add(Object o);

    /**
    * Rimuove un'istanza dell'elemento specificato da questa collezione, se presente. Restituisce true se la collezione viene modificata.
    *
    * @param o l'elemento da rimuovere
    * @return {@code true} se la collezione viene modificata
    * @throws NullPointerException se l'elemento specificato è null
    */
    boolean remove(Object o);

    /**
     * Restituisce true se questa collezione contiene tutti gli elementi della collezione specificata.
     *
     * @param c la collezione contenente gli elementi da verificare
     * @return {@code true} se questa collezione contiene tutti gli elementi della collezione specificata
     * @throws NullPointerException se la collezione specificata è {@code null}
     */
    boolean containsAll(HCollection c);

    /**
     * Aggiunge tutti gli elementi della collezione specificata a questa collezione.
     *
     * @param c la collezione contenente gli elementi da aggiungere
     * @return {@code true} se questa collezione viene modificata
     * @throws UnsupportedOperationException se l'operazione {@code addAll} non è supportata da questa collezione
     * @throws NullPointerException se la collezione specificata è {@code null}
     */
    boolean addAll(HCollection c);

    /**
     * Rimuove tutti gli elementi di questa collezione che sono presenti nella collezione specificata. Restituisce true se la collezione 
     * viene modificata.
     *
     * @param c la collezione contenente gli elementi da rimuovere
     * @return {@code true} se questa collezione viene modificata
     * @throws NullPointerException se la collezione specificata è {@code null}
     */
    boolean removeAll(HCollection c);

    /**
     * Rimuove tutti gli elementi di questa collezione che non sono presenti nella collezione specificata. Restituisce true se la collezione 
     * viene modificata.
     *
     * @param c la collezione contenente gli elementi da mantenere
     * @return {@code true} se questa collezione viene modificata
     * @throws NullPointerException se la collezione specificata è {@code null}
     */
    boolean retainAll(HCollection c);

    /**
    * Rimuove tutti gli elementi da questa collezione. La collezione sarà vuota dopo questa chiamata.
    */
    void clear();

    /**
     * Confronta l'oggetto specificato con questa collezione per verificarne
     * l'uguaglianza.
     *
     * <p>L'interfaccia {@code HCollection} non aggiunge ulteriori condizioni
     * al contratto generale di {@link Object#equals(Object)}. Le
     * implementazioni possono definire criteri di uguaglianza più specifici,
     * purché rispettino le proprietà di riflessività, simmetria, transitività
     * e consistenza previste da {@code Object.equals(Object)}.</p>
     *
     * @param obj l'oggetto da confrontare con questa collezione
     * @return {@code true} se l'oggetto specificato è considerato uguale a
     *         questa collezione; {@code false} altrimenti
     */
    boolean equals(Object o);

    /**
     * Restituisce il codice hash di questa collezione.
     *
     * <p>L'interfaccia {@code HCollection} non impone una formula specifica
     * per il calcolo del codice hash. L'implementazione deve comunque
     * rispettare il contratto generale di {@link Object#hashCode()}: due
     * collezioni considerate uguali da {@link #equals(Object)} devono
     * restituire lo stesso codice hash.</p>
     *
     * @return il codice hash di questa collezione
     */
    int hashCode();
}