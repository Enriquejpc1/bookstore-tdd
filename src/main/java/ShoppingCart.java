import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    //agregar catalogo de libros.
    private final List<String> validEditorial = List.of("redbee", "bluebee");
    private Map<String, Stock> shoppingCart = new HashMap<>();
    private List<Book> catalog;

    public ShoppingCart(List<Book> catalog) {
        this.catalog = catalog;
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

}
