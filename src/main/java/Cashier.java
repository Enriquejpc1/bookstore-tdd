import java.math.BigDecimal;
import java.time.YearMonth;

public class Cashier {

    private ShoppingCart shoppingCart;
    private CreditCard creditCard;
    private MerchantProcessor merchantProcessor;

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

    public BigDecimal checkOut() {
        BigDecimal grandTotal = shoppingCart.calculateTotalAmount();
        merchantProcessor.debit(grandTotal, creditCard);
        return grandTotal;
    }

}
