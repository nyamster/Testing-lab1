import model.Book;
import model.Eagle;
import model.Spider;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    private RedBlackTree t;

    @BeforeEach
    void init() {
        t = new RedBlackTree();
    }

    @Test
    void repeatElementTest() {
        t.insert(0);

        assertEquals(0, t.insert(0));
    }

    @Test
    void bigElementTest() {
        assertEquals(1, t.insert(Integer.MAX_VALUE));
        assertEquals(1, t.insert(Integer.MIN_VALUE));
    }

    @Test
    void clearTest() {
        t.insert(0);
        t.clear();

        assertTrue(t.isEmpty());
    }

    @Test
    void emptyTest() {
        assertTrue(t.isEmpty());
        assertNull(t.findMax());
        assertNull(t.findMin());
        assertNull(t.find(0));
    }

    @Test
    void bigTreeTest() {
        final int NUMS = 400000;
        final int GAP = 35461;

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);

        assertEquals(1, t.findMin());
        assertEquals(NUMS - 1, t.findMax());

        for (int i = 1; i < NUMS; i++)
            assertEquals(i, t.find(i));

        t.clear();
        t.insert(10);
        t.insert(12);
        t.insert(11);

        assertEquals(10, t.find(10));
        assertEquals(11, t.find(11));
        assertEquals(12, t.find(12));
    }
}
