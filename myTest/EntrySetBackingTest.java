package myTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import myAdapter.*;

/**
 * <h2>Test Case - EntrySetBackingTest</h2>
 * <ul>
 * <li><b>Summary:</b> </li>
 * <li><b>Test Case Design:</b> </li>
 * </ul>
 */
public class EntrySetBackingTest {

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

    // Map.Entry class test ----------------------------------------------------------------------------------------------------
    // Object getKey(); ----------------------------------------------------------------------------------------

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
    public void testGetKey() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        Object key = entry.getKey();
        //ASSERT
        assertEquals("La chiave dell'entry non è corretta", "A", key);
    }

    // Object getValue(); --------------------------------------------------------------------------------------

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
    public void testGetValue() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        Object value = entry.getValue();
        //ASSERT
        assertEquals("Il valore dell'entry non è corretto", "ALFA", value);
    }

    // Object setValue(Object value); --------------------------------------------------------------------------

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
    public void testSetValue() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        Object result = entry.setValue("BETA");
        //ASSERT
        assertEquals("setVAlue() non ha restituito il valore precedente corretto", "ALFA", result);
        assertEquals("Il valore dell'entry non è stato aggiornato correttamente", "BETA", entry.getValue());
        assertEquals("Il valore della chiave è cambiato", "A", entry.getKey());

        assertEquals("La dimensione dell'entrySet è variata", 1, entrySet.size());
        iterator = entrySet.iterator();
        entry = (HMap.Entry) iterator.next();
        assertEquals("Non è stato aggiornato il valore dell'entry set", "BETA", entry.getValue());

        assertEquals("La dimensione della mappa è variata", 1, map.size());
        assertEquals("Il valore associato alla chiave A nella mappa non è stato aggiornato correttamente", "BETA", map.get("A"));
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
    public void testSetValueNullPointer() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        Object result = entry.setValue(null);
        //ASSERT
    }

    // boolean equals(Object obj); -----------------------------------------------------------------------------

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
    public void testEqualsWithEqualEntries() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        HMap otherMap = new MapAdapter();
        otherMap.put(new String("A"), new String("ALFA"));
        HSet otherEntrySet = otherMap.entrySet();
        HIterator otherIterator = otherEntrySet.iterator();
        HMap.Entry otherEntry = (HMap.Entry) otherIterator.next();
        //ACT
        boolean result = entry.equals(otherEntry);
        //ASSERT
        assertTrue("Le entry non sono uguali", result);
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
    public void testEqualsWithDifferentKeys() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        HMap otherMap = new MapAdapter();
        otherMap.put("B", "ALFA");
        HSet otherEntrySet = otherMap.entrySet();
        HIterator otherIterator = otherEntrySet.iterator();
        HMap.Entry otherEntry = (HMap.Entry) otherIterator.next();
        //ACT
        boolean result = entry.equals(otherEntry);
        //ASSERT
        assertFalse("Le entry sono uguali", result);
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
    public void testEqualsWithDifferentValues() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        HMap otherMap = new MapAdapter();
        otherMap.put("A", "BETA");
        HSet otherEntrySet = otherMap.entrySet();
        HIterator otherIterator = otherEntrySet.iterator();
        HMap.Entry otherEntry = (HMap.Entry) otherIterator.next();
        //ACT
        boolean result = entry.equals(otherEntry);
        //ASSERT
        assertFalse("Le entry sono uguali", result);
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
    public void testEqualsSameEntry() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        boolean result = entry.equals(entry);
        //ASSERT
        assertTrue("Le entry non sono uguali", result);
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
    public void testEqualsToObject() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        boolean result = entry.equals("A");
        //ASSERT
        assertFalse("Le entry sono uguali", result);
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
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        //ACT
        boolean result = entry.equals(null);
        //ASSERT
        assertFalse("Le entry sono uguali", result);
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
    public void testHashCodeExpected() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        int expectedHashCode = "A".hashCode() ^ "ALFA".hashCode();
        //ACT
        int result = entry.hashCode();
        //ASSERT
        assertEquals("Il codice hash dell'entry non è corretto", expectedHashCode, result);
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
    public void testHashCodeEqualEntries() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        HMap otherMap = new MapAdapter();
        otherMap.put(new String("A"), new String("ALFA"));
        HSet otherEntrySet = otherMap.entrySet();
        HIterator otherIterator = otherEntrySet.iterator();
        HMap.Entry otherEntry = (HMap.Entry) otherIterator.next();
        //ACT
        int result = entry.hashCode();
        int otherResult = otherEntry.hashCode();
        //ASSERT
        assertEquals("I codici hash delle entry non sono uguali", otherResult, result);
    }
    
    // HSet entrySet(); ----------------------------------------------------------------------------------------
       
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
    public void testEntrySetEmptyMap() {
        //ARRANGE
        //ACT
        HSet entrySet = map.entrySet();
        //ASSERT
        assertNotNull("Il set di entry non deve essere null", entrySet);
        assertTrue("Il set di entry deve essere vuoto", entrySet.isEmpty());
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
    public void testEntrySetMap() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        //ACT
        HSet entrySet = map.entrySet();
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 2, entrySet.size());
        boolean foundAAlfa = false;
        boolean foundBBeta = false;
        HIterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            HMap.Entry entry = (HMap.Entry) iterator.next();

            if ("A".equals(entry.getKey())
                    && "ALFA".equals(entry.getValue())) {
                foundAAlfa = true;
            } else if ("B".equals(entry.getKey())
                    && "BETA".equals(entry.getValue())) {
                foundBBeta = true;
            } else {
                fail("entrySet() ha restituito un'entry non presente nella mappa");
            }
        }
        assertTrue("Il set di entry non contiene la coppia (A, ALFA)", foundAAlfa);
        assertTrue("Il set di entry non contiene la coppia (B, BETA)", foundBBeta);
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
    public void testEntrySetMapWithDuplicates() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "ALFA"); // Duplicate value
        //ACT
        HSet entrySet = map.entrySet();
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 3, entrySet.size());
        boolean foundA = false;
        boolean foundB = false;
        boolean foundC = false;
        HIterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            HMap.Entry entry = (HMap.Entry) iterator.next();

            if ("A".equals(entry.getKey())
                    && "ALFA".equals(entry.getValue())) {
                foundA = true;
            } else if ("B".equals(entry.getKey())
                    && "BETA".equals(entry.getValue())) {
                foundB = true;
            } else if ("C".equals(entry.getKey())
                    && "ALFA".equals(entry.getValue())) {
                foundC = true;
            } else {
                fail("entrySet() ha restituito un'entry non presente nella mappa");
            }
        }
        assertTrue("Il set di entry non contiene la coppia (A, ALFA)", foundA);
        assertTrue("Il set di entry non contiene la coppia (B, BETA)", foundB);
        assertTrue("Il set di entry non contiene la coppia (C, ALFA)", foundC);
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
    public void testEntrySetBackedOnMapPutNewAssociation() {
        //ARRANGE
        HSet entrySet = map.entrySet();
        //ACT
        Object oldValue = map.put("A", "ALFA");
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 1, entrySet.size());
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        boolean containsEntry = "A".equals(entry.getKey()) && "ALFA".equals(entry.getValue());
        assertTrue("Il set di entry non contiene la coppia (A, ALFA)", containsEntry);
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
    public void testEntrySetBackedOnMapPutUpdateAssociation() {
        //ARRANGE
        map.put("A", "ALFA");
        HSet entrySet = map.entrySet();
        //ACT
        Object oldValue = map.put(new String("A"), "BETA");
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 1, entrySet.size());
        HIterator iterator = entrySet.iterator();
        HMap.Entry entry = (HMap.Entry) iterator.next();
        boolean containsEntry = "A".equals(entry.getKey()) && "BETA".equals(entry.getValue());
        assertTrue("Il set di entry non contiene la coppia (A, BETA)", containsEntry);
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
    public void testEntrySetBackedOnMapRemove() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HSet entrySet = map.entrySet();
        //ACT
        Object removedValue = map.remove(new String("A"));
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 2, entrySet.size());
        boolean foundB = false;
        boolean foundC = false;
        HIterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            HMap.Entry entry = (HMap.Entry) iterator.next();

            if ("B".equals(entry.getKey())
                    && "BETA".equals(entry.getValue())) {
                foundB = true;
            } else if ("C".equals(entry.getKey())
                    && "CHARLIE".equals(entry.getValue())) {
                foundC = true;
            } else {
                fail("entrySet() ha restituito un'entry non presente nella mappa");
            }
        }
        assertTrue("Il set di entry non contiene la coppia (B, BETA)", foundB);
        assertTrue("Il set di entry non contiene la coppia (C, CHARLIE)", foundC);
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
    public void testEntrySetBackedOnMapPutAllWithNewAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("D", "DELTA");
        HSet entrySet = map.entrySet();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 4, entrySet.size());
        boolean foundA = false;
        boolean foundB = false;
        boolean foundC = false;
        boolean foundD = false;
        HIterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            HMap.Entry entry = (HMap.Entry) iterator.next();

            if ("A".equals(entry.getKey())
                    && "ALFA".equals(entry.getValue())) {
                foundA = true;
            } else if ("B".equals(entry.getKey())
                    && "BETA".equals(entry.getValue())) {
                foundB = true;
            } else if ("C".equals(entry.getKey())
                    && "CHARLIE".equals(entry.getValue())) {
                foundC = true;
            } else if ("D".equals(entry.getKey())
                    && "DELTA".equals(entry.getValue())) {
                foundD = true;
            } else {
                fail("entrySet() ha restituito un'entry non presente nella mappa");
            }
        }
        assertTrue("Il set di entry non contiene la coppia (A, ALFA)", foundA);
        assertTrue("Il set di entry non contiene la coppia (B, BETA)", foundB);
        assertTrue("Il set di entry non contiene la coppia (C, CHARLIE)", foundC);
        assertTrue("Il set di entry non contiene la coppia (D, DELTA)", foundD);
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
    public void testEntrySetBackedOnMapPutAllWithExistingAssociations() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        HMap otherMap = new MapAdapter();
        otherMap.put("C", "CHARLIE");
        otherMap.put("A", "DELTA");
        HSet entrySet = map.entrySet();
        //ACT
        map.putAll(otherMap);
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 3, entrySet.size());
        boolean foundA = false;
        boolean foundB = false;
        boolean foundC = false;
        HIterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            HMap.Entry entry = (HMap.Entry) iterator.next();

            if ("A".equals(entry.getKey())
                    && "DELTA".equals(entry.getValue())) {
                foundA = true;
            } else if ("B".equals(entry.getKey())
                    && "BETA".equals(entry.getValue())) {
                foundB = true;
            } else if ("C".equals(entry.getKey())
                    && "CHARLIE".equals(entry.getValue())) {
                foundC = true;
            } else {
                fail("entrySet() ha restituito un'entry non presente nella mappa");
            }
        }
        assertTrue("Il set di entry non contiene la coppia (A, DELTA)", foundA);
        assertTrue("Il set di entry non contiene la coppia (B, BETA)", foundB);
        assertTrue("Il set di entry non contiene la coppia (C, CHARLIE)", foundC);
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
    public void testEntrySetBackedOnMapClear() {
        //ARRANGE
        map.put("A", "ALFA");
        map.put("B", "BETA");
        map.put("C", "CHARLIE");
        HSet entrySet = map.entrySet();
        //ACT
        map.clear();
        //ASSERT
        assertEquals("Il set di entry non ha la dimensione corretta", 0, entrySet.size());
        assertTrue("Il set di entry non è vuoto", entrySet.isEmpty());
    }
}