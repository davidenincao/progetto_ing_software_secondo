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
public class ValuesCollectionTest {

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

    // All methods of HCollection on HCollection values(); ------------------------------------------------------------------------------------
    // int size(); ---------------------------------------------------------------------------------------------

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
    public void testSizeOnEmptyCollection() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        int size = values.size();
        //ASSERT
        assertEquals("La collezione di valori appena creata non ha dimensione 0", 0, size);
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
    public void testSizeAfterOneInsertion() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        int size = values.size();
        //ASSERT
        assertEquals("La collezione di valori appena creata non ha dimensione 1", 1, size);
    }

    // boolean isEmpty(); --------------------------------------------------------------------------------------

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
    public void testIsEmptyOnEmptyCollection() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        boolean isEmpty = values.isEmpty();
        //ASSERT
        assertTrue("La collezione di valori appena creata non è vuota", isEmpty);
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
    public void testIsEmptyAfterOneInsertion() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        boolean isEmpty = values.isEmpty();
        //ASSERT
        assertFalse("La collezione di valori creata da una mappa con una entry è vuota", isEmpty);
    }

    // boolean contains(Object o); -----------------------------------------------------------------------------

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
    public void testContainsTrue() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        boolean contains = values.contains(new String("ALFA"));
        //ASSERT
        assertTrue("Se il valore e' presente deve restituire true", contains);
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
    public void testContainsFalse() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        boolean contains = values.contains("BETA");
        //ASSERT
        assertFalse("Se il valore non e' presente deve restituire false", contains);
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
    public void testContainsNullPointer() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        boolean contains = values.contains(null);
        //ASSERT
    }

    // HIterator iterator(); -----------------------------------------------------------------------------------

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
    public void testIteratorReturnsNonNullIterator() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        HIterator iterator = values.iterator();
        //ASSERT
        assertNotNull("L'iteratore su collection vuota è null", iterator);
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
    public void testIteratorReturnsIndependentIterators() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        HIterator iterator1 = values.iterator();
        iterator1.next();
        HIterator iterator2 = values.iterator();
        //ASSERT
        assertNotSame("Gli iteratori restituiti da collection.iterator() sono lo stesso oggetto", iterator1, iterator2);
        assertNotEquals("Gli iteratori restituiti da collection.iterator() non sono indipendenti", iterator1.hasNext(), iterator2.hasNext());
    }

    // Object[] toArray(); -------------------------------------------------------------------------------------

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
    public void testToArray() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        Object[] result = values.toArray();
        //ASSERT
        assertEquals("Collection size e array length non sono uguali", values.size(), result.length);
        assertTrue("Il primo elemento nell'array non e' presente nella collezione", values.contains(result[0]));
        assertTrue("Il secondo elemento nell'array non e' presente nella collezione", values.contains(result[1]));
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
    public void testToArrayEmptyCollection() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        Object[] result = values.toArray();
        //ASSERT
        assertEquals("La collezione vuota non ha generato un array vuoto", 0, result.length);
    }

    // Object[] toArray(Object[] a); ---------------------------------------------------------------------------

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
    public void testToArrayWithArraySameSize() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        Object[] input = new Object[2];
        Object[] result = values.toArray(input);
        //ASSERT
        assertSame("L'array ritornato non e' lo stesso dato in input", input, result);
        assertTrue("Il primo elemento nell'array non e' presente nella collezione", values.contains(result[0]));
        assertTrue("Il secondo elemento nell'array non e' presente nella collezione", values.contains(result[1]));
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
    public void testToArrayWithArraySmallerSize() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        Object[] input = new String[1];
        Object[] result = values.toArray(input);
        //ASSERT
        assertNotSame("L'array ritornato e' lo stesso dato in input", input, result);
        assertEquals("L'array restituito deve avere lo stesso tipo runtime dell'array fornito", input.getClass(), result.getClass());
        assertTrue("Il primo elemento nell'array non e' presente nella collezione", values.contains(result[0]));
        assertTrue("Il secondo elemento nell'array non e' presente nella collezione", values.contains(result[1]));
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
    public void testToArrayWithArrayLargerSize() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        Object[] input = new Object[3];
        Object[] result = values.toArray(input);
        //ASSERT
        assertSame("L'array ritornato non e' lo stesso dato in input", input, result);
        assertTrue("Il primo elemento nell'array non e' presente nella collezione", values.contains(result[0]));
        assertTrue("Il secondo elemento nell'array non e' presente nella collezione", values.contains(result[1]));
        assertNull("L'ultima cella dovrebbe essere null", result[2]);
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
    @Test(expected = ArrayStoreException.class)
    public void testToArrayWithArrayWrongClass() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        Object[] input = new Integer[2];
        Object[] result = values.toArray(input);
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
    public void testToArrayWithArrayNull() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        Object[] result = values.toArray(null);
        //ASSERT
    }

    // boolean add(Object o); ----------------------------------------------------------------------------------

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
    @Test(expected = UnsupportedOperationException.class)
    public void testAddUnsupportedOperationException() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        values.add("A");
        //ASSERT
    }

    // boolean remove(Object o); -------------------------------------------------------------------------------

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
    public void testRemovePresent() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean removed = values.remove(new String("ALFA"));
        //ASSERT
        assertTrue("Se il valore e' presente remove deve restituire true", removed);
        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("Dopo la rimozione la collezione non ha la dimensione corretta", 1, values.size());
        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella mappa", map.containsValue("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertEquals("Dopo la rimozione la mappa non ha la dimensione corretta", 1, map.size());
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
    public void testRemoveOneOnly() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "ALFA");
        HCollection values = map.values();
        //ACT
        boolean removed = values.remove(new String("ALFA"));
        //ASSERT
        assertTrue("Se il valore e' presente remove deve restituire true", removed);
        assertTrue("La rimozione deve rimuovere soltato una occorenza", values.contains("ALFA"));
        assertEquals("Dopo la rimozione la collezione non ha la dimensione corretta", 1, values.size());
        assertFalse("La rimozione deve rimuovere soltato una occorenza nella mappa", map.containsValue("ALFA"));
        assertEquals("Dopo la rimozione la mappa non ha la dimensione corretta", 1, map.size());
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
    public void testRemoveAbsent() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean removed = values.remove(new String("DELTA"));
        //ASSERT
        assertFalse("Se il valore non e' presente remove deve restituire false", removed);
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("La dimensione non deve cambiare", 2, values.size());
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertEquals("La dimensione della mappa non deve cambiare", 2, map.size());
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
    public void testRemoveNullPointer() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean removed = values.remove(null);
        //ASSERT
    }

    // boolean containsAll(HCollection c); ---------------------------------------------------------------------

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
    public void testContainsAllTrue() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("X", new String("ALFA"));
        otherMap.put("Y", new String("BETA"));
        HCollection otherValues = otherMap.values();
        //ACT
        boolean contained = values.containsAll(otherValues);
        //ASSERT
        assertTrue("containsAll non restituisce true quando la collezione contiene tutti gli elementi", contained);
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("CHARLIE"));
        assertEquals("La dimensione della collezione non deve cambiare", 3, values.size());
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
    public void testContainsAllFalse() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("X", new String("ALFA"));
        otherMap.put("Y", new String("YANKEE"));
        HCollection otherValues = otherMap.values();
        //ACT
        boolean contained = values.containsAll(otherValues);
        //ASSERT
        assertFalse("containsAll non restituisce false quando la collezione non contiene tutti gli elementi", contained);
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("CHARLIE"));
        assertEquals("La dimensione della collezione non deve cambiare", 3, values.size());
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
    public void testContainsAllEmptyCollection() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        HCollection otherValues = otherMap.values();
        //ACT
        boolean contained = values.containsAll(otherValues);
        //ASSERT
        assertTrue("containsAll non restituisce true quando la collezione è vuota", contained);
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo containsAll il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("La dimensione della collezione non deve cambiare", 2, values.size());
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
    public void testContainsAllNullPointer() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean contained = values.containsAll(null);
        //ASSERT
    }

    // boolean addAll(HCollection c); --------------------------------------------------------------------------

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
    @Test(expected = UnsupportedOperationException.class)
    public void testAddAllUnsupportedOperationException() {
        //ARRANGE
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("A", "ALFA");
        HCollection otherValues = otherMap.values();
        //ACT
        values.addAll(otherValues);
        //ASSERT
    }

    // boolean removeAll(HCollection c); -----------------------------------------------------------------------

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
    public void testRemoveAllPresent() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("X", new String("ALFA"));
        otherMap.put("Y", new String("CHARLIE"));
        HCollection otherValues = otherMap.values();
        //ACT
        boolean removed = values.removeAll(otherValues);
        //ASSERT
        assertTrue("Se il valore e' presente removeAll deve restituire true", removed);
        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella collezione", values.contains("ALFA"));
        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella collezione", values.contains("CHARLIE"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("Dopo la rimozione la collezione non ha la dimensione corretta", 1, values.size());

        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella mappa", map.containsValue("ALFA"));
        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella mappa", map.containsValue("CHARLIE"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertEquals("Dopo la rimozione la mappa non ha la dimensione corretta", 1, map.size());
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
    public void testRemoveAllMultipleInstances() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "ALFA");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("X", new String("ALFA"));
        HCollection otherValues = otherMap.values();
        //ACT
        boolean removed = values.removeAll(otherValues);
        //ASSERT
        assertTrue("Se il valore e' presente removeAll deve restituire true", removed);
        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("Dopo la rimozione la collezione non ha la dimensione corretta", 1, values.size());

        assertFalse("Dopo la rimozione il valore non deve essere piu' presente nella mappa", map.containsValue("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertEquals("Dopo la rimozione la mappa non ha la dimensione corretta", 1, map.size());
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
    public void testRemoveAllAbsent() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("X", new String("DELTA"));
        otherMap.put("Y", new String("YANKEE"));
        HCollection otherValues = otherMap.values();
        //ACT
        boolean removed = values.removeAll(otherValues);
        //ASSERT
        assertFalse("Se il valore non e' presente removeAll deve restituire false", removed);
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella collezione", values.contains("CHARLIE"));
        assertEquals("Se la rimozione non avviene la dimensione della collezione deve rimanere invariata", 3, values.size());

        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("ALFA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertTrue("Dopo la rimozione il valore deve essere ancora presente nella mappa", map.containsValue("CHARLIE"));
        assertEquals("Se la rimozione non avviene la dimensione della mappa deve rimanere invariata", 3, map.size());
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
    public void testRemoveAllNullPointer() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean removed = values.removeAll(null);
        //ASSERT
    }

    // boolean retainAll(HCollection c); -----------------------------------------------------------------------

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
    public void testRetainAllPresent() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("X", new String("ALFA"));
        otherMap.put("Y", new String("BETA"));
        HCollection otherValues = otherMap.values();
        //ACT
        boolean retained = values.retainAll(otherValues);
        //ASSERT
        assertFalse("Se retainAll non modifica la collezione deve restituire false", retained);
        assertTrue("Dopo retainAll il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertTrue("Dopo retainAll il valore deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("Se retainAll non modifica la collezione la dimensione della collezione deve restare invariata", 2, values.size());

        assertTrue("Dopo retainAll il valore deve essere ancora presente nella mappa", map.containsValue("ALFA"));
        assertTrue("Dopo retainAll il valore deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertEquals("Se retainAll non modifica la collezione la dimensione della mappa deve restare invariata", 2, map.size());
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
    public void testRetainAllAbsent() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("X", new String("ALFA"));
        otherMap.put("Y", "YANKEE");
        HCollection otherValues = otherMap.values();
        //ACT
        boolean retained = values.retainAll(otherValues);
        //ASSERT
        assertTrue("Se retainAll modifica la collezione deve restituire true", retained);
        assertTrue("Dopo retainAll il valore deve essere ancora presente nella collezione", values.contains("ALFA"));
        assertFalse("Dopo retainAll il valore non deve essere ancora presente nella collezione", values.contains("BETA"));
        assertEquals("Dopo che retainAll ha modificato la collezione la dimensione deve essere diminuita", 1, values.size());

        assertTrue("Dopo retainAll il valore deve essere ancora presente nella mappa", map.containsValue("ALFA"));
        assertFalse("Dopo retainAll il valore non deve essere ancora presente nella mappa", map.containsValue("BETA"));
        assertEquals("Dopo che retainAll ha modificato la mappa la dimensione deve essere diminuita", 1, map.size());
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
    public void testRetainAllEmptyCollection() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        HMap otherMap = new MapAdapter();
        HCollection otherValues = otherMap.values();
        //ACT
        boolean retained = values.retainAll(otherValues);
        //ASSERT
        assertTrue("Se retainAll modifica la collezione deve restituire true", retained);
        assertFalse("Dopo retainAll il valore non deve essere piu' presente nella collezione", values.contains("ALFA"));
        assertFalse("Dopo retainAll il valore non deve essere piu' presente nella collezione", values.contains("BETA"));
        assertEquals("Dopo retainAll la collezione non ha la dimensione corretta", 0, values.size());

        assertFalse("Dopo retainAll il valore non deve essere piu' presente nella mappa", map.containsValue("ALFA"));
        assertFalse("Dopo retainAll il valore non deve essere piu' presente nella mappa", map.containsValue("BETA"));
        assertEquals("Dopo retainAll la mappa non ha la dimensione corretta", 0, map.size());
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
    public void testRetainAllNullPointer() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean retained = values.retainAll(null);
        //ASSERT
    }

    // void clear(); -------------------------------------------------------------------------------------------

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
    public void testClearOnEmptyCollection() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        values.clear();
        //ASSERT
        assertTrue("La collezione vuota dopo aver chiamato clear() non è più vuota", values.isEmpty());
        assertEquals("La collezione vuota dopo aver chiamato clear() non ha dimensione 0", 0, values.size());

        assertTrue("La mappa vuota dopo aver chiamato clear() sulla collezione non è più vuota", map.isEmpty());
        assertEquals("La mappa vuota dopo aver chiamato clear() sulla collezione non ha dimensione 0", 0, map.size());
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
    public void testClearOnNotEmptyCollection() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        values.clear();
        //ASSERT
        assertTrue("La collezione di valori non è vuota dopo aver chiamato clear()", values.isEmpty());
        assertEquals("La collezione di valori non ha dimensione 0 dopo aver chiamato clear()", 0, values.size());

        assertTrue("La mappa non è vuota dopo aver chiamato clear() sulla collezione", map.isEmpty());
        assertEquals("La mappa non ha dimensione 0 dopo aver chiamato clear() sulla collezione", 0, map.size());
    }

    // boolean equals(Object o); -------------------------------------------------------------------------------

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
    public void testEqualsSameCollection() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        //ACT
        boolean result = values.equals(values);
        //ASSERT
        assertTrue("La collezione deve essere uguale a se stessa", result);
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
    public void testEqualsWithDistinctCollectionsHavingSameValues() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put(new String("B"), new String("BETA"));
        otherMap.put(new String("A"), new String("ALFA"));
        HCollection values = map.values();
        HCollection otherValues = otherMap.values();
        // ACT
        boolean result = values.equals(otherValues);
        // ASSERT
        assertFalse("Due collezioni di valori distinte non devono essere uguali, anche se contengono gli stessi elementi", result);
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
    public void testEqualsWithDistinctEmptyCollections() {
        //ARRANGE
        HMap otherMap = new MapAdapter();
        HCollection values = map.values();
        HCollection otherValues = otherMap.values();
        //ACT
        boolean result = values.equals(otherValues);
        //ASSERT
        assertFalse("Due collezioni distinte vuote non devono essere uguali", result);
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
    public void testEqualsWithIncompatibleObject() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        boolean result = values.equals("A");
        //ASSERT
        assertFalse("Una collezione non puó essere uguale a un oggetto diverso", result);
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
    public void testEqualsToNull() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        boolean result = values.equals(null);
        //ASSERT
        assertFalse("Una collezione non puó essere uguale a null", result);
    }

    // int hashCode(); -----------------------------------------------------------------------------------------

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
    public void testHashCodeIsConsistent() {
        // ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        // ACT
        int firstResult = values.hashCode();
        int secondResult = values.hashCode();
        // ASSERT
        assertEquals("Invocazioni ripetute di hashCode() sulla stessa collezione devono restituire lo stesso valore", firstResult, secondResult);
    }
}