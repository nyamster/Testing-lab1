package model;

import model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelTest {

    private Spider spider;
    private Eagle oryol;
    private Book book;

    @BeforeEach
    void init() {
        spider = new Spider("Владислав", "Уборщик");
        oryol = new Eagle("Евгений", "Хохлатый");
        book = new Book(6);
    }

    @Test
    public void spiderCreateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Spider("", "Правительственный паук"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Spider("Ваня", ""));
    }

    @Test
    public void spiderTest() {
        assertEquals("Владислав", spider.getName());
        assertEquals("Уборщик", spider.getRole());
    }

    @Test
    public void eagleCreateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Eagle("", "Хохлатый"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Eagle("Александр", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Eagle("Евгений", "Хохлатый").checkSafety());
    }

    @Test
    public void eagleTest() {
        assertEquals("Евгений", oryol.getName());
        assertEquals("Хохлатый", oryol.getType());

        assertEquals(60, oryol.buildNest(Material.GARBAGE));
        assertFalse(oryol.checkSafety());

        assertEquals(90, oryol.buildNest(Material.STONE));
        assertTrue(oryol.checkSafety());

        assertEquals(95, oryol.buildNest(Material.PAPER));
        assertEquals(80, oryol.buildNest(Material.WOOD));
        assertEquals(90, oryol.buildNest(Material.STONE));
    }

    @Test
    public void bookCreateTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book(-6));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book(6).pulloutPage(8));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book(6).pulloutPage(-5));

        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book(6).getPage(-5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Book(6).getPage(10));
    }

    @Test
    public void bookTest() {
        book.pulloutPage(4);
        assertFalse(book.getPage(4).isPresent());
        assertEquals(6, book.getPagecount());
    }

}