package myAdapter;

/**
 * Interfaccia HIterator che replica interamente l'interfaccia java.util.Iterator
 * della versione J2SE 1.4.2
 */
public interface HIterator {

    /**
     * Restituisce true se l'iterazione contiene ancora elementi.
     * 
     * @return true se l'iterazione contiene ancora elementi.
     */
    boolean hasNext();

    /**
     * Restituisce l'elemento successivo nell'iterazione.
     * 
     * @return l'elemento successivo nell'iterazione.
     * @throws java.util.NoSuchElementException se l'iterazione non contiene più elementi.
     */
    Object next();

    /**
     * Rimuove dall'origine dell'iterazione l'ultimo elemento restituito da next().
     * 
     * @throws java.lang.IllegalStateException se il metodo next() non è stato chiamato
     *         o se il metodo remove() è già stato chiamato dopo l'ultima chiamata a next().
     */
    void remove();
}