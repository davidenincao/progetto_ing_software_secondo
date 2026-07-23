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
public class ValuesBackingTest {

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

    // HCollection values(); -----------------------------------------------------------------------------------

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
    public void testValuesEmptyMap() {
        //ARRANGE
        //ACT
        HCollection values = map.values();
        //ASSERT
        assertNotNull("La collezione di valori non deve essere null", values);
        assertTrue("La collezione di valori deve essere vuota", values.isEmpty());
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
    public void testValuesMap() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        //ACT
        HCollection values = map.values();
        //ASSERT
        assertEquals("La collezione di valori non ha la dimensione corretta", 2, values.size());
        assertTrue("La collezione di valori non contiene il valore ALFA", values.contains("ALFA"));
        assertTrue("La collezione di valori non contiene il valore BETA", values.contains("BETA"));
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
    public void testValuesMapWithDuplicates() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "ALFA"); // Duplicate value
        //ACT
        HCollection values = map.values();
        //ASSERT
        assertEquals("La collezione di valori non ha la dimensione corretta", 3, values.size());
        assertTrue("La collezione di valori non contiene il valore ALFA", values.contains("ALFA"));
        assertTrue("La collezione di valori non contiene il valore BETA", values.contains("BETA"));
        values.remove("ALFA");
        assertTrue("Dopo la rimozione il valore ALFA deve essere ancora presente nella collezione", values.contains("ALFA"));
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
    public void testValuesBackedOnMapPutNewAssociation() {
        //ARRANGE
        HCollection values = map.values();
        //ACT
        Object oldValue = map.put("A", "ALFA");
        //ASSERT
        assertTrue("La collezione di valori non contiene il valore ALFA", values.contains("ALFA"));
        assertEquals("La collezione di valori non ha la dimensione corretta", 1, values.size());
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
    public void testValuesBackedOnMapPutUpdateAssociation() {
        //ARRANGE
        map.put("A", "ALFA");
        HCollection values = map.values();
        //ACT
        Object oldValue = map.put(new String("A"), "BETA");
        //ASSERT
        assertFalse("La collezione di valori contiene ancora il valore ALFA", values.contains("ALFA"));
        assertTrue("La collezione di valori non contiene il valore BETA", values.contains("BETA"));
        assertEquals("La collezione di valori non ha la dimensione corretta", 1, values.size());
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
    public void testValuesBackedOnMapRemove() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HCollection values = map.values();
        //ACT
        Object removedValue = map.remove(new String("A"));
        //ASSERT
        assertFalse("La collezione di valori contiene ancora il valore ALFA", values.contains("ALFA"));
        assertTrue("La collezione di valori non contiene il valore BETA", values.contains("BETA"));
        assertTrue("La collezione di valori non contiene il valore CHARLIE", values.contains("CHARLIE"));
        assertEquals("La collezione di valori non ha la dimensione corretta", 2, values.size());
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
    public void testValuesBackedOnMapPutAllWithNewAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("D", "DELTA");
        HCollection values = map.values();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertTrue("La collezione di valori non contiene il valore CHARLIE", values.contains("CHARLIE"));
        assertTrue("La collezione di valori non contiene il valore DELTA", values.contains("DELTA"));
        assertTrue("La collezione di valori non contiene il valore ALFA", values.contains("ALFA"));
        assertTrue("La collezione di valori non contiene il valore BETA", values.contains("BETA"));
        assertEquals("La collezione di valori non ha la dimensione corretta", 4, values.size());
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
    public void testValuesBackedOnMapPutAllWithExistingAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("A", "DELTA");
        HCollection values = map.values();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertFalse("La collezione di valori contiene il valore ALFA non è stato sostituito", values.contains("ALFA"));
        assertTrue("La collezione di valori non contiene il valore CHARLIE", values.contains("CHARLIE"));
        assertTrue("La collezione di valori non contiene il valore DELTA", values.contains("DELTA"));
        assertTrue("La collezione di valori non contiene il valore BETA", values.contains("BETA"));
        assertEquals("La collezione di valori non ha la dimensione corretta", 3, values.size());
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
    public void testValuesBackedOnMapClear() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HCollection values = map.values();
        //ACT
        map.clear();
        //ASSERT
        assertFalse("La collezione di valori contiene ancora il valore ALFA", values.contains("ALFA"));
        assertFalse("La collezione di valori contiene ancora il valore BETA", values.contains("BETA"));
        assertFalse("La collezione di valori contiene ancora il valore CHARLIE", values.contains("CHARLIE"));
        assertEquals("La collezione di valori non ha la dimensione corretta", 0, values.size());
    }
}