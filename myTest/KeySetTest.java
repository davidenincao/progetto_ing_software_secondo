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
public class KeySetTest {

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


    // HSet keySet(); ------------------------------------------------------------------------------------------

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
    public void testKeySet() {
        //ARRANGE
        map.put("A", "ALFA");
        //ACT
        HSet keySet = map.keySet();
        //ASSERT
        assertTrue("La mappa non contiene la chiave", keySet.contains("A"));
    }

    // All methods of HSet on HSet keySet(); ---------------------------------------------------------------------------------------------
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
    public void testSizeOnEmptySet() {
        //ARRANGE
        HSet keySet = map.keySet();
        //ACT
        int size = keySet.size();
        //ASSERT
        assertEquals("Il set di chiavi appena creato non ha dimensione 0", 0, size);
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
        HSet keySet = map.keySet();
        //ACT
        int size = keySet.size();
        //ASSERT
        assertEquals("Il set di chiavi appena creato non ha dimensione 1", 1, size);
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
    public void testIsEmptyOnEmptySet() {
        //ARRANGE
        HSet keySet = map.keySet();
        //ACT
        boolean isEmpty = keySet.isEmpty();
        //ASSERT
        assertTrue("Il set di chiavi appena creato non è vuoto", isEmpty);
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
        HSet keySet = map.keySet();
        //ACT
        boolean isEmpty = keySet.isEmpty();
        //ASSERT
        assertFalse("Il set di chiavi creato da una mappa con una entry è vuoto", isEmpty);
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
        HSet keySet = map.keySet();
        //ACT
        boolean contains = keySet.contains(new String("A"));
        //ASSERT
        assertTrue("Se la chiave e' presente deve restituire true", contains);
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
        HSet keySet = map.keySet();
        //ACT
        boolean contains = keySet.contains("B");
        //ASSERT
        assertFalse("Se la chiave non e' presente deve restituire false", contains);
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
        HSet keySet = map.keySet();
        //ACT
        boolean contains = keySet.contains(null);
        //ASSERT
    }

    // HIterator iterator(); -----------------------------------------------------------------------------------
    // Object[] toArray(); -------------------------------------------------------------------------------------
    // Object[] toArray(Object[] a); ---------------------------------------------------------------------------
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
        HSet keySet = map.keySet();
        //ACT
        keySet.add("A");
        //ASSERT
    }

    // boolean remove(Object o); -------------------------------------------------------------------------------
    // boolean containsAll(HCollection c); ---------------------------------------------------------------------
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
        HSet keySet = map.keySet();
        HMap otherMap = new MapAdapter();
        otherMap.put("A", "ALFA");
        HSet otherKeySet = otherMap.keySet();
        //ACT
        keySet.addAll(otherKeySet);
        //ASSERT
    }

    // boolean removeAll(HCollection c); -----------------------------------------------------------------------
    // boolean retainAll(HCollection c); -----------------------------------------------------------------------
    // void clear(); -------------------------------------------------------------------------------------------
    // boolean equals(Object o); -------------------------------------------------------------------------------
    // int hashCode(); -----------------------------------------------------------------------------------------


}