import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Stock {
    private Book book;
    private Integer quantity;

    public void addStock(Integer quantity) {
        this.quantity += quantity;
    }
}
