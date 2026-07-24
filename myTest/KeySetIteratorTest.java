package myTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import myAdapter.*;

/**
 * <h2>Test Case - KeySetIteratorTest</h2>
 * <ul>
 * <li><b>Summary:</b> </li>
 * <li><b>Test Case Design:</b> </li>
 * </ul>
 */
public class KeySetIteratorTest {

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

    // boolean hasNext(); --------------------------------------------------------------------------------------

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
    public void testHasNextOnEmptySet() {
        //ARRANGE
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        //ACT
        boolean result = iterator.hasNext();
        //ASSERT
        assertFalse("Il set di chiavi appena creato ha elementi successivi nell'iterazione", result);
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
    public void testHasNextSetStart() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        //ACT
        boolean result = iterator.hasNext();
        //ASSERT
        assertTrue("hasNext() restituisce false quando l'iteratore ha elementi successivi'", result);
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
    public void testHasNextSetEnd() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        iterator.next();
        iterator.next();
        //ACT
        boolean result = iterator.hasNext();
        //ASSERT
        assertFalse("hasNext() restituisce true quando l'iteratore non ha più elementi", result);
    }

    // Object next(); ------------------------------------------------------------------------------------------

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
    @Test(expected = java.util.NoSuchElementException.class)
    public void testNextNoSuchElementException() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        // ACT + ASSERT
        try {
            iterator.next();
            fail("next() deve lanciare NoSuchElementException quando l'iterazione è terminata");
        } catch (java.util.NoSuchElementException expected) {
            // Comportamento atteso.
        }
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
    public void testNextCompleteIteration() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        boolean foundA = false;
        boolean foundB = false;
        int count = 0;

        // ACT
        while (iterator.hasNext()) {
            Object result = iterator.next();
            count++;

            if ("A".equals(result)) {
                foundA = true;
            } else if ("B".equals(result)) {
                foundB = true;
            } else {
                fail("L'iteratore ha restituito un valore non presente nel set");
            }
        }

        // ASSERT
        assertEquals(
            "L'iteratore deve visitare tutte le chiavi del set",
            2,
            count
        );
        assertTrue("L'iteratore deve restituire la chiave (A)", foundA);
        assertTrue("L'iteratore deve restituire la chiave (B)", foundB);
        assertFalse(
            "hasNext() deve restituire false al termine dell'iterazione",
            iterator.hasNext()
        );
    }

    // void remove(); ------------------------------------------------------------------------------------------

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
    public void testRemoveLegalState() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        Object result = iterator.next();
        //ACT
        iterator.remove();
        //ASSERT
        assertFalse("remove() non rimuove l'elemento corretto", keySet.contains(result));
        assertEquals("La dimensione del set non è corretta dopo la rimozione", 1, keySet.size());
        assertFalse("remove() non si propaga su map", map.containsKey(result));
        assertEquals("La dimensione della mappa non viene modificata dopo la rimozione sul set", 1, map.size());
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
    public void testRemoveAll() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        //ACT
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        //ASSERT
        assertEquals("Il set non è vuoto dopo la rimozione di tutti gli elementi", 0, keySet.size());
        assertEquals("La mappa non è vuota dopo la rimozione di tutti gli elementi dal set", 0, map.size());
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
    @Test(expected = java.lang.IllegalStateException.class)
    public void testRemoveIllegalState() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        //ACT
        iterator.remove();
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
    @Test(expected = java.lang.IllegalStateException.class)
    public void testRemoveTwice() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HSet keySet = map.keySet();
        HIterator iterator = keySet.iterator();
        Object result = iterator.next();
        iterator.remove();
        //ACT
        iterator.remove();
        //ASSERT
    }
}