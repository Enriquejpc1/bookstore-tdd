import java.math.BigDecimal;
import java.util.function.BiConsumer;

public class MerchantProcessorStub implements MerchantProcessor {

    private final BiConsumer debitBehaviour;

    public MerchantProcessorStub(BiConsumer abehaviour) {
        debitBehaviour = abehaviour;
    }

    @Override
    public void debit(BigDecimal amount, CreditCard creditCard) {
        if (creditCard.getAvailableAmount().compareTo(amount) < 0) {
            throw new RuntimeException("Eres pobre loco!");
        }
        debitBehaviour.accept(amount, creditCard);
    }


}
