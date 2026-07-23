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
public class IteratorTest {

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
    public void testHasNextOnEmptyCollection() {
        //ARRANGE
        HCollection values = map.values();
        HIterator iterator = values.iterator();
        //ACT
        boolean result = iterator.hasNext();
        //ASSERT
        assertFalse("La collezione di valori appena creata ha elementi successivi nell'iterazione", result);
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
    public void testHasNextCollectionStart() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        HIterator iterator = values.iterator();
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
    public void testHasNextCollectionEnd() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HCollection values = map.values();
        HIterator iterator = values.iterator();
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
        HCollection values = map.values();
        HIterator iterator = values.iterator();
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
        HCollection values = map.values();
        HIterator iterator = values.iterator();
        boolean foundAlfa = false;
        boolean foundBeta = false;
        int count = 0;

        // ACT
        while (iterator.hasNext()) {
            Object result = iterator.next();
            count++;

            if ("ALFA".equals(result)) {
                assertFalse(
                    "L'associazione contenente ALFA non deve essere visitata due volte",
                    foundAlfa
                );
                foundAlfa = true;
            } else if ("BETA".equals(result)) {
                assertFalse(
                    "L'associazione contenente BETA non deve essere visitata due volte",
                    foundBeta
                );
                foundBeta = true;
            } else {
                fail("L'iteratore ha restituito un valore non presente nella collezione");
            }
        }

        // ASSERT
        assertEquals(
            "L'iteratore deve visitare tutte le associazioni della collezione",
            2,
            count
        );
        assertTrue("L'iteratore deve restituire ALFA", foundAlfa);
        assertTrue("L'iteratore deve restituire BETA", foundBeta);
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

        HIterator iterator = map.values().iterator();
        int count = 0;

        // ACT
        while (iterator.hasNext()) {
            Object result = iterator.next();

            assertEquals(
                "L'iteratore deve restituire il valore contenuto nella collezione",
                "ALFA",
                result
            );
            count++;
        }

        // ASSERT
        assertEquals(
            "L'iteratore deve restituire un elemento per ogni associazione, anche in presenza di valori duplicati",
            2,
            count
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
        HCollection values = map.values();
        HIterator iterator = values.iterator();
        Object result = iterator.next();
        //ACT
        iterator.remove();
        //ASSERT
        assertFalse("remove() rimuove l'elemento corretto", values.contains(result));
        assertEquals("La dimensione della collezione di valori è corretta dopo la rimozione", 1, values.size());
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
        HCollection values = map.values();
        HIterator iterator = values.iterator();
        //ACT
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        //ASSERT
        assertEquals("La collezione di valori è vuota dopo la rimozione di tutti gli elementi", 0, values.size());
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
        HCollection values = map.values();
        HIterator iterator = values.iterator();
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
        HCollection values = map.values();
        HIterator iterator = values.iterator();
        Object result = iterator.next();
        iterator.remove();
        //ACT
        iterator.remove();
        //ASSERT
    }
}