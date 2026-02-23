public class RoomFactory {
    public static Pricable getRoom(int type) {
        return switch (type) {
            case LegacyRoomTypes.SINGLE -> new SingleRoom();
            case LegacyRoomTypes.DOUBLE -> new DoubleRoom();
            case LegacyRoomTypes.TRIPLE -> new TripleRoom();
            default -> new DeluxeRoom();
        };
    }
}