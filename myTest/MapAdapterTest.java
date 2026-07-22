package myTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import myAdapter.*;

/**
 * <h2>Test Case - MapAdapterTest</h2>
 * <ul>
 * <li><b>Summary:</b> </li>
 * <li><b>Test Case Design:</b> </li>
 * </ul>
 */
public class MapAdapterTest {

    MapAdapter map = null;

    /**
     * crea una nuova mappa vuota
     */
    @Before
	public void setup()
	{
		map = new MapAdapter();
	}

    /**
     * l'attributo map viene impostato a null
     */
    @After
	public void tearDown()
	{
		map = null;
	}


    // int size(); ---------------------------------------------------------------------------------------------

    /**
     * <h4>Test Method - testSizeOnEmptyMap</h4>
     * <ul>
     * <li><b>Summary:</b> Verifica che il metodo {@code size()} restituisca zero quando viene invocato su una mappa vuota.</li>
     * <li><b>Test Method Design:</b> Il test verifica il comportamento di {@code size()} nel caso limite 
     * rappresentato da una mappa priva di associazioni. Il valore restituito viene confrontato con la dimensione di una mappa vuota.</li>
     * <li><b>Test Description:</b> TID: SIZE-01. Data un'istanza vuota di {@link MapAdapter}, si invoca 
     * il metodo {@code size()} e si confronta il risultato ottenuto con il valore atteso {@code 0}.</li>
     * <li><b>Pre-Condition:</b> L'istanza di {@link MapAdapter} è una mappa vuota.</li>
     * <li><b>Post-Condition:</b> Lo stato della mappa non viene modificato dall'invocazione di {@code size()}.</li>
     * <li><b>Expected Results:</b> Il metodo {@code size()} restituisce {@code 0}.</li>
     * </ul>
     */
    @Test
    public void testSizeOnEmptyMap() {
        //ARRANGE
        //ACT
        int size = map.size();
        //ASSERT
        assertEquals("La mappa appena creata non ha dimensione 0", 0, size);
    }

    /**
     * <h4>Test Method - testSizeAfterOneInsertion</h4>
     * <ul>
     * <li><b>Summary:</b> Verifica che il metodo {@code size()} restituisca uno quando viene invocato 
     * su una mappa contenente un elemento.</li>
     * <li><b>Test Method Design:</b> Il test verifica il comportamento di {@code size()} nel caso base
     * rappresentato da una mappa con una sola associazione. Il valore restituito viene confrontato con il numero di entry inserite 
     * nella mappa.</li>
     * <li><b>Test Description:</b> TID: SIZE-02. Data un'istanza vuota di {@link MapAdapter}, si inserisce una coppia chiave-valore, 
     * successivamente si invoca il metodo {@code size()} e si confronta il risultato ottenuto con il valore atteso {@code 1}.</li>
     * <li><b>Pre-Condition:</b> L'istanza di {@link MapAdapter} è una mappa contenente una associazione chiave-valore.</li>
     * <li><b>Post-Condition:</b> Lo stato della mappa non viene modificato dall'invocazione di {@code size()}.</li>
     * <li><b>Expected Results:</b> Il metodo {@code size()} restituisce {@code 1}.</li>
     * </ul>
     */
    @Test
    public void testSizeAfterOneInsertion() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        int size = map.size();
        //ASSERT
        assertEquals("La mappa dopo un singolo inserimento non ha dimensione 1", 1, size);
    }

    // boolean isEmpty(); --------------------------------------------------------------------------------------

    /**
     * <h4>Test Method - testIsEmptyOnEmptyMap</h4>
     * <ul>
     * <li><b>Summary:</b> Verifica che il metodo {@code isEmpty()} restituisca {@code true} quando viene invocato su una mappa vuota.</li>
     * <li><b>Test Method Design:</b> Il test verifica il comportamento di {@code isEmpty()} nel caso limite 
     * rappresentato da una mappa priva di associazioni. Il valore restituito viene confrontato con il valore atteso {@code true}.</li>
     * <li><b>Test Description:</b> TID: ISEMPTY-01. Data un'istanza vuota di {@link MapAdapter}, si invoca 
     * il metodo {@code isEmpty()} e si confronta il risultato ottenuto con il valore atteso {@code true}.</li>
     * <li><b>Pre-Condition:</b> L'istanza di {@link MapAdapter} è una mappa vuota.</li>
     * <li><b>Post-Condition:</b> Lo stato della mappa non viene modificato dall'invocazione di {@code isEmpty()}.</li>
     * <li><b>Expected Results:</b> Il metodo {@code isEmpty()} restituisce {@code true}.</li>
     * </ul>
     */
    @Test
    public void testIsEmptyOnEmptyMap() {
        //ARRANGE
        //ACT
        boolean isEmpty = map.isEmpty();
        //ASSERT
        assertTrue("La mappa appena creata non è vuota", isEmpty);
    }

    /**
     * <h4>Test Method - testIsEmptyAfterOneInsertion</h4>
     * <ul>
     * <li><b>Summary:</b> Verifica che il metodo {@code isEmpty()} restituisca {@code false} quando viene invocato 
     * su una mappa contenente un elemento.</li>
     * <li><b>Test Method Design:</b> Il test verifica il comportamento di {@code isEmpty()} nel caso limite
     * rappresentato da una mappa con una sola associazione. Il valore restituito viene confrontato con il valore atteso {@code false}.</li>
     * <li><b>Test Description:</b> TID: ISEMPTY-02. Data un'istanza vuota di {@link MapAdapter}, si inserisce una coppia chiave-valore, 
     * successivamente si invoca il metodo {@code isEmpty()} e si confronta il risultato ottenuto con il valore atteso {@code false}.</li>
     * <li><b>Pre-Condition:</b> L'istanza di {@link MapAdapter} è una mappa contenente una associazione chiave-valore.</li>
     * <li><b>Post-Condition:</b> Lo stato della mappa non viene modificato dall'invocazione di {@code isEmpty()}.</li>
     * <li><b>Expected Results:</b> Il metodo {@code isEmpty()} restituisce {@code false}.</li>
     * </ul>
     */
    @Test
    public void testIsEmptyAfterOneInsertion() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        boolean isEmpty = map.isEmpty();
        //ASSERT
        assertFalse("La mappa dopo un singolo inserimento è vuota", isEmpty);
    }

    // boolean containsKey(Object key); ------------------------------------------------------------------------

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsKeyOnEmptyMap() {
        //ARRANGE
        //ACT
        boolean containsKey = map.containsKey("A");
        //ASSERT
        assertFalse("La mappa vuota contiene la chiave", containsKey);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsKeyWithPresentKey() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        boolean containsKey = map.containsKey(new String("A"));
        //ASSERT
        assertTrue("La mappa non contiene la chiave", containsKey);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsKeyWithAbsentKey() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        boolean containsKey = map.containsKey("B");
        //ASSERT
        assertFalse("La mappa non ritorna false tramite containsKey() con chiave assente", containsKey);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testContainsKeyNullPointer() {
        //ARRANGE
        //ACT
        map.containsKey(null);
        //ASSERT
    }

    // boolean containsValue(Object value); --------------------------------------------------------------------

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsValueOnEmptyMap() {
        //ARRANGE
        //ACT
        boolean containsValue = map.containsValue("ALFA");
        //ASSERT
        assertFalse("La mappa vuota contiene il valore", containsValue);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsValueWithPresentValue() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        boolean containsValue = map.containsValue(new String("ALFA"));
        //ASSERT
        assertTrue("La mappa non contiene il valore", containsValue);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsValueWithMultiplePresentValue() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "ALFA");
        //ACT
        boolean containsValue = map.containsValue(new String("ALFA"));
        //ASSERT
        assertTrue("La mappa non contiene il valore usando containsValue() con occorrenze multiple", containsValue);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testContainsValueWithAbsentValue() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        boolean containsValue = map.containsValue("BETA");
        //ASSERT
        assertFalse("La mappa contiene il valore", containsValue);
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testContainsValueNullPointer() {
        //ARRANGE
        //ACT
        map.containsValue(null);
        //ASSERT
    }

    // Object get(Object key); ---------------------------------------------------------------------------------

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testGetOnEmptyMap() {
        //ARRANGE
        //ACT
        Object value = map.get("A");
        //ASSERT
        assertNull("La mappa vuota ritorna un valore non nullo tramite get()", value);
    }

    /**
     * <h4>Test Method - testGetWithPresentKey</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testGetWithPresentKey() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        Object value = map.get(new String("A"));
        //ASSERT
        assertEquals("La mappa non ritorna il valore corretto tramite get()", "ALFA", value);
    }

    /**
     * <h4>Test Method - testGetWithAbsentKey</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testGetWithAbsentKey() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        Object value = map.get("B");
        //ASSERT
        assertNull("La mappa ritorna un valore non nullo tramite get() con chiave assente", value);
    }

    /**
     * <h4>Test Method - testGetNullPointer</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testGetNullPointer() {
        //ARRANGE
        //ACT
        map.get(null);
        //ASSERT
    }

    // void put(Object key, Object value); ---------------------------------------------------------------------

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testPutNewAssociation() {
        //ARRANGE
        //ACT
        Object oldValue = map.put("A", "ALFA");
        //ASSERT
        assertNull("La mappa ritorna un valore non nullo tramite put() con chiave assente", oldValue);
        assertTrue("La mappa non contiene la chiave appena inserita tramite put()", map.containsKey("A"));
        assertTrue("La mappa non contiene il valore appena inserito tramite put()", map.containsValue("ALFA"));
        assertEquals("La mappa non ritorna il valore corretto tramite get() dopo put()", "ALFA", map.get("A"));
        assertEquals("La mappa non ha dimensione 1 dopo put()", 1, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testPutUpdateAssociation() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        Object oldValue = map.put(new String("A"), "BETA");
        //ASSERT
        assertEquals("La mappa non ritorna il valore corretto tramite put() con chiave presente", "ALFA", oldValue);
        assertTrue("La mappa non contiene più la chiave dopo aver modificato l'associazione tramite put()", map.containsKey("A"));
        assertTrue("La mappa non contiene il valore appena inserito tramite put()", map.containsValue("BETA"));
        assertFalse("La mappa contiene il vecchio valore dopo put()", map.containsValue("ALFA"));
        assertEquals("La mappa non ritorna il valore corretto tramite get() dopo put()", "BETA", map.get("A"));
        assertEquals("La mappa non ha più dimensione 1 dopo aver modificato l'associazione tramite put()", 1, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testPutNullKey() {
        //ARRANGE
        //ACT
        map.put(null, "ALFA");
        //ASSERT
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testPutNullValue() {
        //ARRANGE
        //ACT
        map.put("A", null);
        //ASSERT
    }

    // Object remove(Object key); ------------------------------------------------------------------------------

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testRemoveWithPresentKey() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        //ACT
        Object removedValue = map.remove(new String("A"));
        //ASSERT
        assertEquals("La mappa non ritorna il valore corretto tramite remove() con chiave presente", "ALFA", removedValue);
        assertFalse("La mappa contiene la chiave dopo averla rimossa tramite remove()", map.containsKey("A"));
        assertFalse("La mappa contiene il valore dopo averlo rimosso tramite remove()", map.containsValue("ALFA"));
        assertNull("La mappa non ritorna null tramite get() dopo remove()", map.get("A"));
        assertEquals("remove() ha modificato le altre associazioni nella mappa", "BETA", map.get("B"));
        assertEquals("remove() ha modificato le altre associazioni nella mappa", "CHARLIE", map.get("C"));
        assertEquals("La mappa non ha dimensione 2 dopo aver rimosso un elemento tramite remove()", 2, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testRemoveMakesEmpty() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        Object removedValue = map.remove(new String("A"));
        //ASSERT
        assertEquals("La mappa non ritorna il valore corretto tramite remove() con chiave presente", "ALFA", removedValue);
        assertEquals("La mappa non ha dimensione 0 dopo aver rimosso l'unico elemento tramite remove()", 0, map.size());
        assertTrue("La mappa non è vuota dopo aver rimosso l'unico elemento tramite remove()", map.isEmpty());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testRemoveWithAbsentKey() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        Object removedValue = map.remove("B");
        //ASSERT
        assertNull("La mappa non ritorna null tramite remove() con chiave assente", removedValue);
        assertEquals("La mappa non ritorna il valore corretto tramite get() dopo aver rimosso un elemento inesistente", "ALFA", map.get("A"));
        assertEquals("La mappa non ha dimensione 1 dopo aver rimosso un elemento inesistente tramite remove()", 1, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testRemoveNullKey() {
        //ARRANGE
        //ACT
        map.remove(null);
        //ASSERT
    }

    // void putAll(HMap m); ------------------------------------------------------------------------------------

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testPutAllWithEmptyMap() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertEquals("putAll() con una mappa vuota non deve modificare la dimensione", 2, map.size());
        assertEquals("putAll() con una mappa vuota non deve modificare le associazioni esistenti", "ALFA", map.get("A"));
        assertEquals("putAll() con una mappa vuota non deve modificare le associazioni esistenti", "BETA", map.get("B"));
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testPutAllWithNewAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("D", "DELTA");
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertEquals("putAll() deve inserire tutte le nuove associazioni", "CHARLIE", map.get("C"));
        assertEquals("putAll() deve inserire tutte le nuove associazioni", "DELTA", map.get("D"));
        assertEquals("putAll() non deve modificare le associazioni già presenti", "ALFA", map.get("A"));
        assertEquals("putAll() non deve modificare le associazioni già presenti", "BETA", map.get("B"));
        assertEquals("L'inserimento di due nuove associazioni deve portare la dimensione a 4", 4, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testPutAllWithExistingAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("A", "DELTA");
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertEquals("putAll() deve inserire tutte le nuove associazioni", "CHARLIE", map.get("C"));
        assertEquals("putAll() deve modificare le associazioni con stessa chiave", "DELTA", map.get("A"));
        assertEquals("putAll() non deve modificare le associazioni già presenti", "BETA", map.get("B"));
        assertEquals("L'inserimento di una nuova associazione deve portare la dimensione a 3", 3, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testPutAllWithSameMap() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        //ACT
        map.putAll(map);
        //ASSERT
        assertEquals("putAll() con la stessa mappa non deve modificare le associazioni", "ALFA", map.get("A"));
        assertEquals("putAll() con la stessa mappa non deve modificare le associazioni", "BETA", map.get("B"));
        assertEquals("La dimensione deve rimanere invariata dopo putAll() con la stessa mappa", 2, map.size());
    }

    /**
     * <h4>Test Method - test</h4>
     * <ul>
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test(expected = NullPointerException.class)
    public void testPutAllNullMap() {
        //ARRANGE
        //ACT
        map.putAll(null);
        //ASSERT
    }

    // void clear(); -------------------------------------------------------------------------------------------

    

    // boolean equals(Object o); -------------------------------------------------------------------------------
    // int hashCode(); -----------------------------------------------------------------------------------------


}