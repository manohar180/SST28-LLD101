import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        TicketService service = new TicketService();

        IncidentTicket t1 = service.createTicket("TCK-1001", "reporter@example.com", "Payment failing");
        System.out.println("Created: " + t1);

        IncidentTicket t2 = service.assign(t1, "agent@example.com");
        IncidentTicket t3 = service.escalateToCritical(t2);
        
        System.out.println("Original still MEDIUM: " + t1.getPriority());
        System.out.println("New instance is CRITICAL: " + t3.getPriority());

        try {
            List<String> tags = t3.getTags();
            tags.add("HACKED"); 
        } catch (UnsupportedOperationException e) {
            System.out.println("\nSUCCESS: External mutation blocked by defensive copying.");
        }
    }
}