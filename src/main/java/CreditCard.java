import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.With;

import java.math.BigDecimal;
import java.time.YearMonth;

@Data
@Builder
@AllArgsConstructor
public class CreditCard {
    private String number;
    private YearMonth expirationDate;
    private String cardHolder;
    private BigDecimal availableAmount;
    @With
    private boolean isStolen;



}
