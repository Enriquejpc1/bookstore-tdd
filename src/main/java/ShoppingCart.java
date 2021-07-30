import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ShoppingCart {
    private final List<String> validEditorial = List.of("redbee", "bluebee");
    private Map<String, Stock> shoppingCart = new HashMap<>();
    private List<Book> catalog;
    private UUID idCart;

    public UUID getIdCart() {
        return idCart;
    }
    public  ShoppingCart(){
        this.idCart = generateCartUUID();
    }

    public ShoppingCart(List<Book> catalog) {
        this.catalog = catalog;
        this.idCart = generateCartUUID();
    }

    public Boolean isEmpty() {
        return shoppingCart.isEmpty();
    }

    public void add(Book book) {
        this.addWithQuantity(book, 1);
    }

    public Boolean containsBook(String isbn) {
        return shoppingCart.containsKey(isbn);
    }

    public void addWithQuantity(Book book, Integer quantity) {
        validateBookEditorial(book);
        validateQuantityOfBookCopies(quantity);
        if (shoppingCart.containsKey(book.getIsbn())) {
            shoppingCart.get(book.getIsbn()).addStock(quantity);
        } else {
            shoppingCart.put(book.getIsbn(), new Stock(book, quantity));
        }
    }

    public Integer getShoppingCartLength() {
        return shoppingCart.size();
    }

    public Integer getCopyQuantity(String isbn) {
        return shoppingCart.get(isbn).getQuantity();
    }

    private void validateBookEditorial(Book book) {
        if (!validEditorial.contains(book.getEditorial())) {
            throw new RuntimeException("Editorial invalida");
        }
    }

    private void validateQuantityOfBookCopies(Integer copies) {
        if (copies <= 0) {
            throw new RuntimeException("Cantidad invalida");
        }
    }
    private UUID generateCartUUID() {
        return UUID.randomUUID();
    }

    public BigDecimal calculateTotalAmount() {
        BigDecimal totalAmount = new BigDecimal(0);
        for (Stock book : shoppingCart.values()) {
            totalAmount = totalAmount.add(book.getBook().getPrice().multiply(BigDecimal.valueOf(book.getQuantity())));
        }
        return totalAmount;
    }
}
