import java.util.List;
import java.util.stream.Collectors;

public class ResumeScorer {
    public static int calculateMatchScore(List<String> resumeSkills, List<String> jobSkills) {
        long matchedSkills = resumeSkills.stream().filter(jobSkills::contains).count();
        return (int) ((matchedSkills * 100.0) / jobSkills.size());
    }

    public static List<String> suggestMissingSkills(List<String> resumeSkills, List<String> jobSkills) {
        return jobSkills.stream().filter(skill -> !resumeSkills.contains(skill)).collect(Collectors.toList());
    }
}
