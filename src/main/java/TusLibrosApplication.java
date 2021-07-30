import java.util.UUID;

/**
 * 1.- No crear carrito con usuario invalido - DONE
 * 2.- No crear carrito con pass invalida - DONE
 * 3.- Cuando se crea un carrito, verificar que este vacio. - DONE
 */

public class TusLibrosApplication {

    public UUID createCart(String idUser, String pass) {
        checkValidUserId(idUser);
        checkUserPass(pass);
        ShoppingCart shoppingCart = new ShoppingCart();
        checkEmptyShoppingCart(shoppingCart);
        return shoppingCart.getIdCart();
    }

    private void checkValidUserId(String idUser) {
        if (idUser.isEmpty()) {
            throw new RuntimeException("Invalid User Id");
        }
    }

    private void checkUserPass(String pass) {
        if (pass.isEmpty()) {
            throw new RuntimeException("Invalid User Password");
        }
    }

    private void checkEmptyShoppingCart (ShoppingCart cart) {
        if (!cart.isEmpty()) {
            throw new RuntimeException("Invalid cart, must be empty");
        }
    }

}
