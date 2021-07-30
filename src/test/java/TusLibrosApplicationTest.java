import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TusLibrosApplicationTest {
    private final String INVALID_USER_ID = "";
    private final String VALID_USER_ID = "validUserId";
    private final String INVALID_USER_PASS = "";
    private final String VALID_USER_PASS = "validUserPass";

    @Test
    void cannotCreateShoppingCartWithInvalidUser() {
        TusLibrosApplication tusLibrosApplication = new TusLibrosApplication();
        assertThrows(RuntimeException.class, () -> {
            tusLibrosApplication.createCart(INVALID_USER_ID, VALID_USER_PASS);
        }, "Invalid User Id");

    }

    @Test
    void cannotCreateShoppingCartWithInvalidPassword() {
        TusLibrosApplication tusLibrosApplication = new TusLibrosApplication();
        assertThrows(RuntimeException.class, () -> {
            tusLibrosApplication.createCart(VALID_USER_ID, INVALID_USER_PASS);
        });
    }

    @Test
    void checkEmptyCartWhenCreation() {
        TusLibrosApplication tusLibros = new TusLibrosApplication();
        assertDoesNotThrow(() -> {
            tusLibros.createCart(VALID_USER_ID, VALID_USER_PASS);
        });
    }

}
