
import java.time.YearMonth;

public class CreditCardStubs {
    private static YearMonth yearMonth = YearMonth.now();

    public static CreditCard getValidCard() {
        return CreditCard.builder()
            .number("1234554546")
            .cardHolder("Elsa Bueso")
            .expirationDate(yearMonth.plusMonths(1l))
            .build();
    }

    public static CreditCard getInvalidCard() {
        return CreditCard.builder()
            .number("1234554546")
            .cardHolder("Elsa Bueso")
            .expirationDate(yearMonth.minusMonths(1l))
            .build();
    }
}
