import java.math.BigDecimal;
import java.util.List;

public class ShoppingCartStubs {
    public static List<Book> bookCatalog() {
        Book bookOne = BookFactory.newBookWithRedbeeEditorial("1", "Dr. Jekyll & Mr. Hyde",BigDecimal.valueOf(11));
        Book bookTwo = BookFactory.newBookWithRedbeeEditorial("2", "Señor de los anillos",BigDecimal.valueOf(12));
        Book bookThree = BookFactory.newBookWithRedbeeEditorial("3", "Harry Potter 1",BigDecimal.valueOf(7));
        Book bookFour = BookFactory.newBookWithBluebeeEditorial("4", "El Principito",BigDecimal.valueOf(5));
        Book bookFive = BookFactory.newBookWithBluebeeEditorial("5", "Todo es posible gracias a la familia",BigDecimal.valueOf(999));
        return List.of(bookOne, bookTwo, bookThree, bookFour, bookFive);
    }
}
