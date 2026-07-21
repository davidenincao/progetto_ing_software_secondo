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
     * crea una nuova mappa
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
     * <li><b>Summary:</b> </li>
     * <li><b>Test Method Design:</b> </li>
     * <li><b>Test Description:</b> </li>
     * <li><b>Pre-Condition:</b> </li>
     * <li><b>Post-Condition:</b> </li>
     * <li><b>Expected Results:</b> </li>
     * </ul>
     */
    @Test
    public void testSizeOnEmptyMap() {
        assertEquals("La mappa appena creata non ha dimensione 0", 0, map.size());
    }

    /**
     * <h4>Test Method - testSizeOnEmptyMap</h4>
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
    public void testSizeOnNotEmptyMap() {
        String key = new String("A");
        String value = new String("ALFA");
        map.put(key, value);

        assertEquals("La mappa dopo un singolo inserimento non ha dimensione 1", 1, map.size());
    }

    // boolean isEmpty(); --------------------------------------------------------------------------------------

    /**
     * <h4>Test Method - testIsEmptyOnEmptyMap</h4>
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
    public void testIsEmptyOnEmptyMap() {
        assertTrue("La mappa appena creata non è vuota", map.isEmpty());
    }

    /**
     * <h4>Test Method - testIsEmptyOnNotEmptyMap</h4>
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
    public void testIsEmptyOnNotEmptyMap() {
        String key = new String("A");
        String value = new String("ALFA");
        map.put(key, value);

        assertFalse("La mappa dopo un singolo inserimento è vuota", map.isEmpty());
    }

    // boolean containsKey(Object key); ------------------------------------------------------------------------
    // boolean containsValue(Object value); --------------------------------------------------------------------
    // Object get(Object key); ---------------------------------------------------------------------------------

    /**
     * <h4>Test Method - testGetOnEmptyMap</h4>
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
        String key = new String("A");

        assertNull("La mappa vuota ritorna un valore non nullo tramite get()", map.get(key));
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
        String key1 = new String("A");
        String value1 = new String("ALFA");
        map.put(key1, value1);
        String key2 = new String("B");
        String value2 = new String("BRAVO");
        map.put(key2, value2);
        String key3 = new String("C");
        String value3 = new String("CHARLIE");
        map.put(key3, value3);

        assertEquals("La mappa non ritorna il valore corretto tramite get()", value1, map.get(key1));
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
        String key1 = new String("A");
        String value1 = new String("ALFA");
        map.put(key1, value1);
        String key2 = new String("B");
        String value2 = new String("BRAVO");
        map.put(key2, value2);
        String key3 = new String("C");
        String value3 = new String("CHARLIE");
        map.put(key3, value3);

        assertNull("La mappa ritorna un valore non nullo tramite get() con chiave assente", map.get("D"));
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
        assertNull("get() con chiave null non lancia NullPointerException", map.get(null));
    }


    // void put(Object key, Object value); ---------------------------------------------------------------------
    // Object remove(Object key); ------------------------------------------------------------------------------
    // void putAll(HMap m); ------------------------------------------------------------------------------------
    // void clear(); -------------------------------------------------------------------------------------------
    // boolean equals(Object o); -------------------------------------------------------------------------------
    // int hashCode(); -----------------------------------------------------------------------------------------


}