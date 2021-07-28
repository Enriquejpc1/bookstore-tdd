import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * 1.- Validar que el carrito no esté vacio. - DONE
 * 2.- Validar TDC valida por fecha. - DONE
 * 3.- Que el cajero calcule correctamente el totalAmount. - DONE
 */

public class CashierTest {


    @Test
    void cantRecieveEmptyShoppingCart() {
        assertThrows(RuntimeException.class, () ->
                new Cashier(new ShoppingCart(ShoppingCartStubs.bookCatalog()), CreditCardStubs.getValidCard()),
            "Carrito invalido, está vacío."
        );
    }

    @Test
    void checkCreditCardIsExpired() {
        assertThrows(RuntimeException.class, () ->
                new Cashier(ShoppingCartStubs.getValidshoppingcart(), CreditCardStubs.getInvalidCard()),
            "Tarjeta Expirada. Bye."
        );
    }

    @Test
    void checkCreditCardIsNotExpired() {
        assertDoesNotThrow(() -> new Cashier(ShoppingCartStubs.getValidshoppingcart(), CreditCardStubs.getValidCard()));
    }

    @Test
    void checkoutShoppingCart() {
        ShoppingCart cart = ShoppingCartStubs.getValidshoppingcart();
        Cashier cashier = new Cashier(cart, CreditCardStubs.getValidCard());
        assertThat(cashier.checkOut()).isEqualTo(cart.calculateTotalAmount());
    }
}
