public class Main {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        
        // 1. Create Data
        Submission sub = new Submission("23BCS1007", "public class A{}", "A.java");
        Rubric rubric = new Rubric();

        // 2. Instantiate Concretes
        IPlagiarismChecker pc = new PlagiarismChecker();
        ICodeGrader grader = new CodeGrader();
        IReportWriter writer = new ReportWriter();

        // 3. Inject dependencies into the pipeline
        EvaluationPipeline pipeline = new EvaluationPipeline(pc, grader, writer, rubric);
        
        // 4. Run
        pipeline.evaluate(sub);
    }
}