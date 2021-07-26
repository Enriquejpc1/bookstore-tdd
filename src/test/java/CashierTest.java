import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.- Validar que el carrito no esté vacio. - DONE
 * 2.-
 */

public class CashierTest {

    @Test
    void cantRecieveEmptyShoppingCart (){
        assertThrows(RuntimeException.class, () ->
                new Cashier(new ShoppingCart(ShoppingCartStubs.bookCatalog()))
        );
    }

}
