import java.util.*;

public class OnboardingService {
    private final StudentRepository repository;
    private final InputParser parser;
    private final StudentValidator validator;
    private final OnboardingUI ui;

    public OnboardingService(StudentRepository repository){
        this.repository = repository;
        this.parser = new InputParser();
        this.validator = new StudentValidator();
        this.ui = new OnboardingUI();
    }

    public void registerFromRawInput(String raw){
        ui.printInput(raw);
        Map<String,String> data = parser.parse(raw);
        List<String> errors = validator.validate(data);
        if (!errors.isEmpty()) {
            ui.printErrors(errors);
            return;
        }
        String id = IdUtil.nextStudentId(repository.count());
        StudentRecord record = new StudentRecord(id, data.get("name"), data.get("email"), data.get("phone"), data.get("program"));
        repository.save(record);
        ui.printSuccess(id, repository.count(), record);
    }
}
