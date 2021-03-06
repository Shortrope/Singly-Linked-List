import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LListTest {

    LList list;

    @Before
    public void setUp() throws Exception {
        list = new LList();
        list.add("5th");
        list.add("4th");
        list.add("3rd");
        list.add("2nd");
        list.add("1st");
    }

    @Test
    public void testGetSize_of_non_empyt_list() throws Exception {
        // non-empty list
        assertEquals(5, list.getSize()); // The list is initialized with 5 items
    }
    @Test
    public void testGetSize_of_empyt_list() throws Exception {
        list.clear();
        assertEquals(0, list.getSize());
    }
    @Test
    public void testClear_the_list() {
        assertEquals(5, list.getSize()); // The list is initialized with 5 items
        assertEquals("1st", list.getFirst());
        assertEquals("5th", list.getLast());
        list.clear();
        assertEquals(0, list.getSize());
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    /*------------ Add to list -------------------------*/
    @Test
    public void testAdd_to_empty_list() {
        list.clear();
        list.add("1st");
        assertEquals("1st", list.getFirst());
        assertEquals(1, list.getSize()); // The list is initialized with 5 items
    }
    @Test
    public void testAdd_to_nonEmpty_list() {
        assertEquals("1st", list.getFirst());
        list.add("New item");
        assertEquals("New item", list.getFirst());
        assertEquals(6, list.getSize()); // The list is initialized with 5 items
    }
    @Test
    public void testAddFirst() {
        list.addFirst("New 1st");
        assertEquals("New 1st", list.getFirst());
        assertEquals(6, list.getSize()); // The list is initialized with 5 items
        list.addFirst("Newer 1st");
        assertEquals("Newer 1st", list.getFirst());
        assertEquals(7, list.getSize());
    }
    @Test
    public void testAddLast_to_empty_list() {
        list.clear();
        list.addLast("New Last");
        assertEquals("New Last", list.getLast());
        assertEquals(1, list.getSize()); // The list is initialized with 5 items
    }
    @Test
    public void testAddLast_to_nonEmpty_list() {
        assertEquals("5th", list.getLast());
        list.addLast("New Last");
        assertEquals("New Last", list.getLast());
        assertEquals(6, list.getSize()); // The list is initialized with 5 items
    }
    @Test
    public void testAddIndex_to_good_index() {
        assertEquals("3rd", list.getIndex(2));
        assertEquals(true, list.addIndex("New 3rd", 2));
        assertEquals("New 3rd", list.getIndex(2));
        assertEquals("3rd", list.getIndex(3));
        assertEquals(6, list.getSize()); // The list is initialized with 5 items
    }
    @Test
    public void testAddIndex_to_bad_index() {
        assertEquals(false, list.addIndex("Bad Index", 5));
        assertEquals(false, list.addIndex("Bad Index", -1));
        assertEquals(5, list.getSize()); // The list is initialized with 5 items
    }

    /*------------ get value from list -------------------------*/
    @Test
    public void testGet_on_empty_list() {
        list.clear();
        assertNull(list.getFirst());
    }
    @Test
    public void testGet_on_nonEmpty_list() {
        assertEquals("1st", list.getFirst());
    }
    @Test
    public void testGetFirst_on_empty_list() {
        list.clear();
        assertNull(list.getFirst());
    }
    @Test
    public void testGetFirst_on_nonEmpty_list() {
        assertEquals("1st", list.getFirst());
    }
    @Test
    public void testGetLast_on_empty_list() {
        list.clear();
        assertNull(list.getLast());
    }
    @Test
    public void testGetLast_on_nonEmpty_list() {
        assertEquals("5th", list.getLast());
    }
    @Test
    public void testGetIndex_from_good_index() {
        assertEquals("1st", list.getIndex(0));
        assertEquals("3rd", list.getIndex(2));
    }
    @Test
    public void testGetIndex_from_bad_index() {
        assertNull(list.getIndex(-1));
        assertNull(list.getIndex(5));
    }

    /*------------ set value in list item -------------------------*/
    @Test
    public void testSet_value_of_item_at_good_index() {
        assertEquals("3rd", list.getIndex(2));
        assertEquals(true, list.set(2, "New 3rd"));
        assertEquals("New 3rd", list.getIndex(2));
    }
    @Test
    public void testSet_value_of_item_at_bad_index() {
        assertEquals(false, list.set(-1, "Bad Index"));
        assertEquals(false, list.set(5, "Bad Index"));
    }

    /*------------ remove item in list ----------------------------*/
    @Test
    public void testRemove() {
        assertEquals("1st", list.remove());
        assertEquals(4, list.getSize()); // The list is initialized with 5 items
        assertEquals("2nd", list.getFirst());
    }
    @Test
    public void testRemoveFirst() {
        assertEquals("1st", list.removeFirst());
        assertEquals(4, list.getSize()); // The list is initialized with 5 items
        assertEquals("2nd", list.getFirst());
    }
    @Test
    public void testRemoveLast() {
        assertEquals("5th", list.removeLast());
        assertEquals(4, list.getSize()); // The list is initialized with 5 items
        assertEquals("4th", list.getLast());
    }
    @Test
    public void testRemoveIndex_good_index() {
        assertEquals("3rd", list.removeIndex(2));
        assertEquals(4, list.getSize()); // The list is initialized with 5 items
        assertEquals("4th", list.getIndex(2));
    }
    @Test
    public void testRemoveIndex_bad_index() {
        assertNull(list.removeIndex(-1));
        assertNull(list.removeIndex(5));
    }


}