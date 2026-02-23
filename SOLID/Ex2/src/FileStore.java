import java.util.*;

public class FileStore implements InvoiceRepository {
    private final Map<String, String> files = new HashMap<>();

    @Override
    public void save(String id, String content) {
        files.put(id, content);
    }

    @Override
    public int countLines(String id) {
        String content = files.getOrDefault(id, "");
        if (content.isEmpty()) return 0;
        return content.split("\n").length;
    }
}