import java.util.List;

public class OrderSummary {
    public final String invId;
    public final List<OrderLine> lines;
    public final double subtotal;
    public final double taxRate;
    public final double taxAmount;
    public final double discount;
    public final double total;

    public OrderSummary(String invId, List<OrderLine> lines, double subtotal, 
                        double taxRate, double taxAmount, double discount, double total) {
        this.invId = invId; this.lines = lines; this.subtotal = subtotal;
        this.taxRate = taxRate; this.taxAmount = taxAmount; 
        this.discount = discount; this.total = total;
    }
}