import java.math.BigDecimal;
import java.time.YearMonth;

public class Cashier {

    private ShoppingCart shoppingCart;
    private CreditCard creditCard;
    private MerchantProcessor merchantProcessor;
    private boolean hasCheckedOut;

    public Cashier(ShoppingCart shoppingCart, CreditCard creditCard, MerchantProcessor merchantProcessor) {
        this.shoppingCart = shoppingCart;
        this.creditCard = creditCard;
        this.merchantProcessor = merchantProcessor;
        validateNotEmptyShoppingCart();
        validateCreditCardIsNotExpired();
        validateNotStolen();

    }


    private void validateCreditCardIsNotExpired() {
        if (creditCard.getExpirationDate().isBefore(YearMonth.now()))
            throw new RuntimeException("Tarjeta Expirada. Bye.");
    }

    private void validateNotEmptyShoppingCart() {
        if (shoppingCart.isEmpty()) {
            throw new RuntimeException("Carrito invalido, está vacío.");
        }
    }

    private void validateNotStolen() {
        if (creditCard.isStolen()) {
            throw new RuntimeException("Tarjeta reportada como robada.");
        }
    }

    private void assertCartHasNotCheckedout() {
        if (hasCheckedOut) {
            throw new RuntimeException(("Solo puede hacer checkout una vez."));
        }
    }

    public BigDecimal checkOut() {
        assertCartHasNotCheckedout();
        try {
            BigDecimal grandTotal = shoppingCart.calculateTotalAmount();
            merchantProcessor.debit(grandTotal, creditCard);
            return grandTotal;
        } finally {
            hasCheckedOut = true;
        }

    }

}
