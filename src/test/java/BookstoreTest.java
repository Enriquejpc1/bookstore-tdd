import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


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
        assertEquals("OK", new ShoppingCart().add("20000 Leguas"));
    }

    @Test
    void addTwoDifferentBookTest() {
        assertEquals("OK", new ShoppingCart().add("20000 Leguas"));
        assertEquals("OK", new ShoppingCart().add("Dr. Jekyll & Mr. Hyde"));
    }


}
