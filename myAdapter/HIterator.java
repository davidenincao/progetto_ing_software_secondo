package myAdapter;

/**
 * Interfaccia HIterator che replica interamente l'interfaccia java.util.Iterator
 * della versione J2SE 1.4.2
 */
public interface HIterator {
    boolean hasNext();
    Object next();
    void remove();
}