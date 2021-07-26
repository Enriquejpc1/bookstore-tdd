import java.math.BigDecimal;

public class BookFactory {

    public static Book newBookWithRedbeeEditorial(String isbn, String name, BigDecimal price) {
        return new Book(isbn, name, "redbee", price);
    }

    public static Book newBookWithBluebeeEditorial(String isbn, String name, BigDecimal price) {
        return new Book(isbn, name, "bluebee", price);
    }
}
