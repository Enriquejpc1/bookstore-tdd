import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


/**
 * 1. Comienzo shopping con carrito vacío - DONE
 * 2. Agrego un libro y el carrito lo guarda - DONE
 * 3. Agrego 2 o más libros diferentes y los contiene - DONE
 * 4. Agrego más de 1 ejemplar al mismo y los contiene - DONE - Libro y cantidad de veces
 * 5. Agrego un libro más de una vez y los contiene - DONE - Libros por separado
 * 6. No puedo agregar libros que no pertenecen a la editorial - DONE
 * 7. Sólo puedo agregar cantidades estrictamente positivas de libros - DONE
 **/

public class ShoppingCartTest {

    @Test
    void emptyShoppingCartTest() {
        assertTrue(new ShoppingCart(ShoppingCartStubs.bookCatalog()).isEmpty());
    }

    @Test
    void addBookTest() {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCartStubs.bookCatalog());
        Book leguas = BookFactory.newBookWithBluebeeEditorial("1", "2000 Leguas", BigDecimal.valueOf(9));
        shoppingCart.add(leguas);
        assertTrue(shoppingCart.containsBook(leguas.getIsbn()));
        assertFalse(shoppingCart.isEmpty());
    }

    @Test
    void addTwoDifferentBookTest() {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCartStubs.bookCatalog());
        shoppingCart.add(BookFactory.newBookWithRedbeeEditorial("1", "2000 Leguas", BigDecimal.valueOf(9)));
        shoppingCart.add(BookFactory.newBookWithBluebeeEditorial("2", "Dr. Jekyll & Mr. Hyde", BigDecimal.valueOf(11)));
        assertFalse(shoppingCart.isEmpty());
        assertTrue(shoppingCart.containsBook("1"));
        assertTrue(shoppingCart.containsBook("2"));
        assertEquals(2, shoppingCart.getShoppingCartLength());
    }

    @Test
    void addMoreThanOneBook() {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCartStubs.bookCatalog());
        Book book = BookFactory.newBookWithRedbeeEditorial("1", "2000 Leguas", BigDecimal.valueOf(9));
        shoppingCart.addWithQuantity(book, 2);
        assertTrue(shoppingCart.containsBook("1"));
        assertEquals(2, shoppingCart.getCopyQuantity(book.getIsbn()));
    }

    @Test
    void addTwoSameCopyBookTest() {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCartStubs.bookCatalog());
        Book book = BookFactory.newBookWithRedbeeEditorial("1", "2000 Leguas", BigDecimal.valueOf(9));
        shoppingCart.add(book);
        shoppingCart.add(book);
        assertFalse(shoppingCart.isEmpty());
        assertEquals(2, shoppingCart.getCopyQuantity(book.getIsbn()));
        assertEquals(1, shoppingCart.getShoppingCartLength());
        assertTrue(shoppingCart.containsBook("1"));
    }

    @Test
    void cantAddBooksOfCertainEditorial() {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCartStubs.bookCatalog());
        Book book = new Book("1", "Gay Mostron", "greenbee", BigDecimal.valueOf(10));
        assertThrows(RuntimeException.class, () ->
                shoppingCart.add(book)
        );
    }

    @Test
    void cantAddNegativeQuantityOfBooks() {
        ShoppingCart shoppingCart = new ShoppingCart(ShoppingCartStubs.bookCatalog());
        Book book = BookFactory.newBookWithRedbeeEditorial("1", "2000 Leguas", BigDecimal.valueOf(9));
        assertThrows(RuntimeException.class, () ->
                shoppingCart.addWithQuantity(book, -1)
        );
    }


}
