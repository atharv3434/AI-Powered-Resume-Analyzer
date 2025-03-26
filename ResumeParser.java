import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ResumeParser {
    private static final List<String> COMMON_SKILLS = Arrays.asList(
            "Java", "Python", "SQL", "AWS", "Machine Learning", "Spring Boot", "Docker", "Kubernetes"
    );

    public static List<String> extractSkills(String text) {
        List<String> extractedSkills = new ArrayList<>();
        for (String skill : COMMON_SKILLS) {
            if (text.toLowerCase().contains(skill.toLowerCase())) {
                extractedSkills.add(skill);
            }
        }
        return extractedSkills;
    }
}
