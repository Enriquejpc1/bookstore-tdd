import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Book {
    private String isbn;
    private String name;
    private String editorial;
    private BigDecimal price;
}
