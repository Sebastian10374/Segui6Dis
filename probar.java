import org.junit.Test;
import static org.junit.Assert.*;

public class SortedListTest {

    @Test
    public void testInsertToEmptyList() {
        SortedList<Integer> list = new SortedList<>();
        list.insert(5);
        assertEquals("[5]", list.toString());

        list.insert(3);
        list.insert(7);
        assertEquals("[3, 5, 7]", list.toString());
    }

    @Test
    public void testSearch() {
        SortedList<Integer> list = new SortedList<>();
        list.insert(3);
        list.insert(5);
        list.insert(7);

        assertTrue(list.search(5));
        assertFalse(list.search(4));
        assertFalse(list.search(8));
        assertTrue(list.search(3));
        assertTrue(list.search(7));
    }

    @Test
    public void testDelete() {
        SortedList<Integer> list = new SortedList<>();
        list.insert(3);
        list.insert(5);
        list.insert(7);

        assertTrue(list.delete(5));
        assertEquals("[3, 7]", list.toString());

        assertFalse(list.delete(4));
        assertEquals("[3, 7]", list.toString());

        assertTrue(list.delete(3));
        assertTrue(list.delete(7));
        assertEquals("[]", list.toString());

        assertFalse(list.delete(3));
        assertEquals("[]", list.toString());
    }

    @Test
    public void testOtherOperations() {
        SortedList<Integer> list = new SortedList<>();
        assertTrue(list.isEmpty());
        list.insert(5);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("[5]", list.toString());

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());

        list.insert(3);
        list.insert(5);
        list.insert(7);
        assertTrue(list.isOrdered());
        assertTrue(list.hasDuplicates());
    }
}