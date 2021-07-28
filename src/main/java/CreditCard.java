import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Data
@Builder
@AllArgsConstructor
public class CreditCard {
    private String number;
    private YearMonth expirationDate;
    private String cardHolder;


}
