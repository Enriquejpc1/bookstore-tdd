public class BookFactory {

    public static Book newBookWithRedbeeEditorial (String isbn,String name) {
        return new Book(isbn,name,"redbee");
    }
    public static Book newBookWithBluebeeEditorial (String isbn,String name) {
        return new Book(isbn,name,"bluebee");
    }
}
