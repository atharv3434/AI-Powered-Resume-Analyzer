import java.io.IOException;
import java.util.List;

public class ResumeAnalyzer {
    public static void main(String[] args) {
        try {
            String resumeText = FileHandler.readFile("resume.txt");
            String jobDescText = FileHandler.readFile("job_description.txt");

            List<String> resumeSkills = ResumeParser.extractSkills(resumeText);
            List<String> jobSkills = ResumeParser.extractSkills(jobDescText);

            int score = ResumeScorer.calculateMatchScore(resumeSkills, jobSkills);

            System.out.println("\n🔍 Resume Analysis Report:");
            System.out.println("Extracted Skills: " + resumeSkills);
            System.out.println("Matching Skills: " + score + "% match with Job Description");

            if (score < 70) {
                System.out.println("\n🔹 Suggested Improvements: Add more relevant skills such as " +
                        ResumeScorer.suggestMissingSkills(resumeSkills, jobSkills));
            } else {
                System.out.println("\n✅ Your resume is well-optimized!");
            }
        } catch (IOException e) {
            System.out.println("Error reading files: " + e.getMessage());
        }
    }
}
