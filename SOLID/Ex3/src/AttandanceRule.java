import java.util.*;
public class AttandanceRule implements EligibilityRule {
    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.attendancePct < 75) return Optional.of("attendance below 75");
        return Optional.empty();
    }
    
}
