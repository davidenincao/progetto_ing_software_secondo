package myAdapter;

/**
 * Interfaccia HSet che replica interamente l'interfaccia java.util.HSet
 * della versione J2SE 1.4.2
 */
public interface HSet extends HCollection{

    int size();
    boolean isEmpty();

    /**
    * Restituisce true se l'insieme contiene l'oggetto specificato.
    *
    * @param o l'oggetto di cui verificare la presenza.
    * @return true se l'insieme contiene l'oggetto specificato.
    * @throws NullPointerException se l'oggetto specificato è null.
    */
    boolean contains(Object o);

    HIterator iterator();
    Object[] toArray();
    Object[] toArray(Object[] a);
    boolean add(Object o);
    boolean remove(Object o);
    boolean containsAll(HCollection c);
    boolean addAll(HCollection c);
    boolean removeAll(HCollection c);
    boolean retainAll(HCollection c);
    void clear();
    boolean equals(Object o);
    int hashCode();
}