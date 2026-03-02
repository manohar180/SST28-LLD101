public class TransportBookingService {
    private final IDistanceCalculator distCalc;
    private final IDriverAllocator allocator;
    private final IPaymentGateway gateway;

    // Dependency Injection via Constructor
    public TransportBookingService(IDistanceCalculator distCalc, 
                                   IDriverAllocator allocator, 
                                   IPaymentGateway gateway) {
        this.distCalc = distCalc;
        this.allocator = allocator;
        this.gateway = gateway;
    }

    public void book(TripRequest req) {
        // Now using injected abstractions instead of local 'new' calls
        double km = distCalc.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = allocator.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = 50.0 + km * 6.6666666667;
        fare = Math.round(fare * 100.0) / 100.0;

        String txn = gateway.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}