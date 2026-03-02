import java.util.*;

public class DeviceRegistry {
    private final List<Object> devices = new ArrayList<>();

    public void add(Object d) { devices.add(d); }

    @SuppressWarnings("unchecked")
    public <T> T getFirstOfCapability(Class<T> capability) {
        for (Object d : devices) {
            if (capability.isInstance(d)) return (T) d;
        }
        throw new IllegalStateException("Missing device with capability: " + capability.getSimpleName());
    }
}