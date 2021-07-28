import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.YearMonth;

public class Cashier {

    private ShoppingCart shoppingCart;
    private CreditCard creditCard;

    public Cashier(ShoppingCart shoppingCart, CreditCard creditCard) {
        validateNotEmptyShoppingCart(shoppingCart);
        validateCreditCardIsNotExpired(creditCard);
        this.shoppingCart = shoppingCart;
        this.creditCard = creditCard;
    }

    private void validateCreditCardIsNotExpired(CreditCard creditCard) {
        if (creditCard.getExpirationDate().isBefore(YearMonth.now()))
            throw new RuntimeException("Tarjeta Expirada. Bye.");
    }

    private void validateNotEmptyShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart.isEmpty()) {
            throw new RuntimeException("Carrito invalido, está vacío.");
        }
    }

    public BigDecimal checkOut() {
        return shoppingCart.calculateTotalAmount();
    }
}
