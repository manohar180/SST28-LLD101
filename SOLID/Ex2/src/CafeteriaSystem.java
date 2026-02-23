import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository repository;
    private final InvoiceFormatter formatter = new InvoiceFormatter();
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceRepository repo) { this.repository = repo; }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        
        double subtotal = 0;
        for (OrderLine l : lines) subtotal += menu.get(l.itemId).price * l.qty;

        double taxPct = TaxRules.taxPercent(customerType);
        double taxAmt = subtotal * (taxPct / 100.0);
        double discAmt = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + taxAmt - discAmt;

        OrderSummary summary = new OrderSummary(invId, lines, subtotal, taxPct, taxAmt, discAmt, total);
        String output = formatter.format(summary, menu);

        System.out.print(output);
        repository.save(invId, output);
        System.out.println("Saved invoice: " + invId + " (lines=" + repository.countLines(invId) + ")");
    }
}