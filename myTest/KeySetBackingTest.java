package myTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import myAdapter.*;

/**
 * <h2>Test Case - ValuesBackingTest</h2>
 * <ul>
 * <li><b>Summary:</b> </li>
 * <li><b>Test Case Design:</b> </li>
 * </ul>
 */
public class KeySetBackingTest {

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
    public void testKeySetEmptyMap() {
        //ARRANGE
        //ACT
        HSet keySet = map.keySet();
        //ASSERT
        assertNotNull("Il set di chiavi non deve essere null", keySet);
        assertTrue("Il set di chiavi deve essere vuoto", keySet.isEmpty());
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
    public void testKeySetMap() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        //ACT
        HSet keySet = map.keySet();
        //ASSERT
        assertEquals("Il set di chiavi non ha la dimensione corretta", 2, keySet.size());
        assertTrue("Il set di chiavi non contiene la chiave A", keySet.contains("A"));
        assertTrue("Il set di chiavi non contiene la chiave B", keySet.contains("B"));
    }

    // All methods that modify map -----------------------------------------------------------------------------

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
    public void testKeySetBackedOnMapPutNewAssociation() {
        //ARRANGE
        HSet keySet = map.keySet();
        //ACT
        Object oldValue = map.put("A", "ALFA");
        //ASSERT
        assertTrue("Il set di chiavi non contiene la chiave A", keySet.contains("A"));
        assertEquals("Il set di chiavi non ha la dimensione corretta", 1, keySet.size());
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
    public void testKeySetBackedOnMapPutUpdateAssociation() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet keySet = map.keySet();
        //ACT
        Object oldValue = map.put(new String("A"), "BETA");
        //ASSERT
        assertTrue("Il set di chiavi non contiene più la chiave A", keySet.contains("A"));
        assertEquals("Il set di chiavi non ha la dimensione corretta", 1, keySet.size());
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
    public void testKeySetBackedOnMapRemove() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HSet keySet = map.keySet();
        //ACT
        Object removedValue = map.remove(new String("A"));
        //ASSERT
        assertFalse("Il set di chiavi contiene ancora la chiave A", keySet.contains("A"));
        assertTrue("Il set di chiavi non contiene la chiave B", keySet.contains("B"));
        assertTrue("Il set di chiavi non contiene la chiave C", keySet.contains("C"));
        assertEquals("Il set di chiavi non ha la dimensione corretta", 2, keySet.size());
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
    public void testKeySetBackedOnMapPutAllWithNewAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("D", "DELTA");
        HSet keySet = map.keySet();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertTrue("Il set di chiavi non contiene la chiave C", keySet.contains("C"));
        assertTrue("Il set di chiavi non contiene la chiave D", keySet.contains("D"));
        assertTrue("Il set di chiavi non contiene la chiave A", keySet.contains("A"));
        assertTrue("Il set di chiavi non contiene la chiave B", keySet.contains("B"));
        assertEquals("Il set di chiavi non ha la dimensione corretta", 4, keySet.size());
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
    public void testKeySetBackedOnMapPutAllWithExistingAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("A", "DELTA");
        HSet keySet = map.keySet();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertFalse("Il set di chiavi non contiene più la chiave A, il cui valore è stato sostituito", keySet.contains("A"));
        assertTrue("Il set di chiavi non contiene la chiave C", keySet.contains("C"));
        assertTrue("Il set di chiavi non contiene la chiave D", keySet.contains("B"));
        assertEquals("Il set di chiavi non ha la dimensione corretta", 3, keySet.size());
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
    public void testKeySetBackedOnMapClear() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HSet keySet = map.keySet();
        //ACT
        map.clear();
        //ASSERT
        assertFalse("Il set di chiavi contiene ancora la chiave A", keySet.contains("A"));
        assertFalse("Il set di chiavi contiene ancora la chiave B", keySet.contains("B"));
        assertFalse("Il set di chiavi contiene ancora la chiave C", keySet.contains("C"));
        assertEquals("Il set di chiavi non ha la dimensione corretta", 0, keySet.size());
    }
}