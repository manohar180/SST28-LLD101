import java.util.*;
public class CreditsRule implements EligibilityRule {
    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.earnedCredits < 20) return Optional.of("Credits below 20");
        return Optional.empty();
    }
}