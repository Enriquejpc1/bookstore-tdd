public class Cashier {

    private ShoppingCart shoppingCart;
    private CreditCard creditCard;

    public Cashier(ShoppingCart shoppingCart) {
        validateNotEmptyShoppingCart(shoppingCart);
        this.shoppingCart = shoppingCart;
    }

    private void validateNotEmptyShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart.isEmpty()) {
            throw new RuntimeException("Carrito invalido, está vacío.");
        }
    }
}
