public class InvoiceFormatter {
    public String format(OrderSummary s, java.util.Map<String, MenuItem> menu) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(s.invId).append("\n");

        for (OrderLine l : s.lines) {
            MenuItem item = menu.get(l.itemId);
            sb.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, item.price * l.qty));
        }

        sb.append(String.format("Subtotal: %.2f\n", s.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", s.taxRate, s.taxAmount));
        sb.append(String.format("Discount: -%.2f\n", s.discount));
        sb.append(String.format("TOTAL: %.2f\n", s.total));
        return sb.toString();
    }
}