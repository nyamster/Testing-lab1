import model.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Model model tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModelTest {

    @Test
    public void SpiderTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Spider("", "Правительственный паук"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Spider("Ваня", ""));

        Spider spider = new Spider("Владислав", "Уборщик");

        assertEquals("Владислав", spider.getName());
        assertEquals("Уборщик", spider.getRole());
    }

    @Test
    public void EagleTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Eagle("", "Хохлатый"));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Eagle("Александр", ""));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Eagle("Евгений", "Хохлатый").checkSafety());

        Eagle oryol = new Eagle("Евгений", "Хохлатый");

        assertEquals("Евгений", oryol.getName());
        assertEquals("Хохлатый", oryol.getType());

        assertEquals(60, oryol.buildNest(Material.GARBAGE));
        assertEquals(false, oryol.checkSafety());

        assertEquals(90, oryol.buildNest(Material.STONE));
        assertEquals(true, oryol.checkSafety());

        assertEquals(95, oryol.buildNest(Material.PAPER));
        assertEquals(80, oryol.buildNest(Material.WOOD));
        assertEquals(90, oryol.buildNest(Material.STONE));
    }

    @Test
    public void BookTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Book(-6));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Book(6).pulloutPage(8));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Book(6).pulloutPage(-5));

        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Book(6).getPage(-5));
        Assertions.assertThrows(IllegalArgumentException.class, () ->  new Book(6).getPage(10));

        Book book = new Book(6);
        book.pulloutPage(4);
        assertEquals(false, book.getPage(4).isPresent());
        assertEquals(6, book.getPagecount());
    }

}