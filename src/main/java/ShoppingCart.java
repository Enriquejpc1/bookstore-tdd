import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<String> shoppingCart = new ArrayList<>();

    public Boolean isEmpty() {
        return shoppingCart.isEmpty();
    }

    public String add(String book) {
        shoppingCart.add(book);
        return "OK";
    }
}
