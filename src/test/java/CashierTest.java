import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

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
                        new Cashier(new ShoppingCart(ShoppingCartStubs.bookCatalog()), CreditCardStubs.getValidCard(), new MerchantProcessorDummy()),
                "Carrito invalido, está vacío."
        );
    }

    @Test
    void checkCreditCardIsExpired() {
        assertThrows(RuntimeException.class, () ->
                        new Cashier(ShoppingCartStubs.getValidshoppingcart(), CreditCardStubs.getInvalidCard(), new MerchantProcessorDummy()),
                "Tarjeta Expirada. Bye."
        );
    }

    @Test
    void checkCreditCardIsNotExpired() {
        assertDoesNotThrow(() -> new Cashier(ShoppingCartStubs.getValidshoppingcart(), CreditCardStubs.getValidCard(), new MerchantProcessorDummy()));
    }

    @Test
    void checkoutShoppingCart() {
        ShoppingCart cart = ShoppingCartStubs.getValidshoppingcart();
        Cashier cashier = new Cashier(cart, CreditCardStubs.getValidCard(), new MerchantProcessorDummy());
        assertThat(cashier.checkOut()).isEqualTo(cart.calculateTotalAmount());
    }

    @Test
    void canCheckOutOnlyOnce() {
        ShoppingCart cart = ShoppingCartStubs.getValidshoppingcart();
        CreditCard creditCardX = CreditCardStubs.getValidCard().withStolen(false);
        Cashier cashier = new Cashier(cart, creditCardX, new MerchantProcessorDummy());
        cashier.checkOut();
        assertThrows(RuntimeException.class, () -> {
                    cashier.checkOut();
                },"Solo puede hacer checkout una vez.");
    }

    @Test
    void checkCreditCardstolen() {
        assertThrows(RuntimeException.class, () ->
                        new Cashier(ShoppingCartStubs.getValidshoppingcart(), CreditCardStubs.getValidCard().withStolen(true), new MerchantProcessorDummy()),
                "Tarjeta reportada como robada.");
    }

    @Test
    void checkoutShoppingMerchantProcessorIsNotAvailable() {
        ShoppingCart cart = ShoppingCartStubs.getValidshoppingcart();
        Cashier cashier = new Cashier(cart, CreditCardStubs.getValidCard(),
                new MerchantProcessorStub((amount, creditCard) -> {
                    throw new RuntimeException("503 - Merchant Processor is not available");
                }));
        assertThrows(RuntimeException.class, () -> cashier.checkOut(),
                "503 - Merchant Processor is not available");
    }

    @Test
    void checkoutShoppingMerchantProcessorAmountIsNotEnough() {
        ShoppingCart cart = ShoppingCartStubs.getValidshoppingcart();
        CreditCard creditCardX = CreditCardStubs.getValidCard().withStolen(false);
        BiConsumer<BigDecimal, CreditCard> consumer = (amount, creditCard) -> {
            if (creditCard.getAvailableAmount().compareTo(amount)<0)
            throw new RuntimeException("Eres pobre loco!");
        };
        Cashier cashier = new Cashier(cart, creditCardX, new MerchantProcessorStub(consumer));
        assertThrows(RuntimeException.class, cashier::checkOut);
    }

    @Test
    void canCheckoutCorrectly () {
        ShoppingCart cart = ShoppingCartStubs.getValidshoppingcartWithLittlePrince();
        CreditCard creditCardX = CreditCardStubs.getValidCard().withStolen(false);
        BiConsumer<BigDecimal, CreditCard> consumer = (amount, creditCard) -> {
            assertEquals(creditCard,creditCardX);
            assertEquals(amount,cart.calculateTotalAmount());
        };
        new Cashier(cart, creditCardX, new MerchantProcessorStub(consumer)).checkOut();
    }
}
