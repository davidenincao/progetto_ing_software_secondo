package myTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import myAdapter.*;

/**
 * <h2>Test Case - EntrySetIteratorTest</h2>
 * <ul>
 * <li><b>Summary:</b> </li>
 * <li><b>Test Case Design:</b> </li>
 * </ul>
 */
public class EntrySetIteratorTest {

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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        //ACT
        boolean result = iterator.hasNext();
        //ASSERT
        assertFalse("Il set di entry appena creato ha elementi successivi nell'iterazione", result);
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        boolean foundAlfa = false;
        boolean foundBeta = false;
        int count = 0;

        // ACT
        while (iterator.hasNext()) {
            HMap.Entry result = (HMap.Entry) iterator.next();
            count++;

            if ("ALFA".equals(result.getValue()) && "A".equals(result.getKey())) {
                foundAlfa = true;
            } else if ("BETA".equals(result.getValue()) && "B".equals(result.getKey())) {
                foundBeta = true;
            } else {
                fail("L'iteratore ha restituito un valore non presente nel set");
            }
        }

        // ASSERT
        assertEquals(
            "L'iteratore deve visitare tutte le associazioni del set",
            2,
            count
        );
        assertTrue("L'iteratore deve restituire la entry (A, ALFA)", foundAlfa);
        assertTrue("L'iteratore deve restituire la entry (B, BETA)", foundBeta);
        assertFalse(
            "hasNext() deve restituire false al termine dell'iterazione",
            iterator.hasNext()
        );
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
    public void testNextCompleteIterationDuplicatedValues() {
        // ARRANGE
        map.put("A", "ALFA");
        map.put("B", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        int count = 0;

        // ACT
        while (iterator.hasNext()) {
            HMap.Entry result = (HMap.Entry) iterator.next();

            count++;

            if ("ALFA".equals(result.getValue()) && "A".equals(result.getKey())) {
                foundA = true;
            } else if ("ALFA".equals(result.getValue()) && "B".equals(result.getKey())) {
                foundB = true;
            } else {
                fail("L'iteratore ha restituito un valore non presente nel set");
            }
        }

        // ASSERT
        assertEquals(
            "L'iteratore deve restituire un elemento per ogni associazione, anche in presenza di valori duplicati",
            2,
            count
        );
        assertTrue("L'iteratore deve restituire la entry (A, ALFA)", foundA);
        assertTrue("L'iteratore deve restituire la entry (B, ALFA)", foundB);
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry result = (HMap.Entry) iterator.next();
        //ACT
        iterator.remove();
        //ASSERT
        assertFalse("remove() non rimuove l'elemento corretto", entrySet.contains(result));
        assertEquals("La dimensione del set non è corretta dopo la rimozione", 1, entrySet.size());
        assertFalse("remove() non si propaga su map", map.containsKey(result.getKey()));
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        //ACT
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        //ASSERT
        assertEquals("Il set non è vuoto dopo la rimozione di tutti gli elementi", 0, entrySet.size());
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
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
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        Object result = iterator.next();
        iterator.remove();
        //ACT
        iterator.remove();
        //ASSERT
    }
}