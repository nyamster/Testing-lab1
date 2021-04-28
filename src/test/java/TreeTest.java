import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {
    @Test
    void repeatElementTest() {
        RedBlackTree t = new RedBlackTree();
        t.insert(0);

        assertEquals(0, t.insert(0));
    }

    @Test
    void bigElementTest() {
        RedBlackTree t = new RedBlackTree();

        assertEquals(1, t.insert(Integer.MAX_VALUE));
        assertEquals(1, t.insert(Integer.MIN_VALUE));
    }

    @Test
    void clearTest() {
        RedBlackTree t = new RedBlackTree();
        t.insert(0);
        t.clear();

        assertEquals(true, t.isEmpty());
    }

    @Test
    void emptyTest() {
        RedBlackTree t = new RedBlackTree();

        assertEquals(true, t.isEmpty());
        assertEquals(null, t.findMax());
        assertEquals(null, t.findMin());
        assertEquals(null, t.find(0));
    }

    @Test
    void bigTreeTest() {
        RedBlackTree t = new RedBlackTree();
        final int NUMS = 400000;
        final int GAP = 35461;

        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            t.insert(i);

        assertEquals(1, t.findMin());
        assertEquals(NUMS - 1, t.findMax());

        for (int i = 1; i < NUMS; i++)
            assertEquals(i, t.find(i));
    }
}
