import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 1. Comienzo shopping con carrito vacío - DONE
 * 2. Agrego un libro y el carrito lo guarda - DONE
 * 3. Agrego 2 o más libros diferentes y los contiene - DONE
 * 4. Agrego más de 1 ejemplar al mismo y los contiene
 * 5. Agrego un libro más de una vez y los contiene
 * 6. No puedo agregar libros que no pertenecen a la editorial
 * 7. Sólo puedo agregar cantidades estrictamente positivas de libros
 **/


public class BookstoreTest {

    @Test
    void emptyShoppingCartTest() {
        assertTrue(new ShoppingCart().isEmpty());
    }

    @Test
    void addBookTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals("OK", shoppingCart.add("20000 Leguas"));
        assertFalse(shoppingCart.isEmpty());
    }

    @Test
    void addTwoDifferentBookTest() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals("OK", shoppingCart.add("20000 Leguas"));
        assertEquals("OK", shoppingCart.add("Dr. Jekyll & Mr. Hyde"));
        assertFalse(shoppingCart.isEmpty());
    }

}
