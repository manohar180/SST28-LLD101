import java.util.*;
public class DisciplineRule implements EligibilityRule {
    @Override
    public Optional<String> check(StudentProfile s) {
        if (s.disciplinaryFlag != 0) return Optional.of("disciplinary flag is set");
        return Optional.empty();
    }
    
}
