import java.math.BigDecimal;

public interface MerchantProcessor {

    void debit(BigDecimal amount, CreditCard creditCard);
}
