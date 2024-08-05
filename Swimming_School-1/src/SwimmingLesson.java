import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SwimmingLesson {
    private static int nextId = 1;

    private int id;
    private String day;
    private String time;
    private int month; 
    private int grade;
    private Coach coach;
    private List<Learner> learners;

    public SwimmingLesson(String day, String time, int grade, Coach coach) {
        this.id = nextId++;
        this.day = day;
        this.time = time;
        this.month = month;
        this.grade = grade;
        this.coach = coach;
        this.learners = new ArrayList<>();
    }

    private int parseMonth(String day) {
       
        String[] parts = day.split(" ");
        String monthStr = parts[1];
        
        return Integer.parseInt(monthStr);
    }
    
    public int getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public int getGrade() {
        return grade;
    }

    public Coach getCoach() {
        return coach;
    }

    public List<Learner> getLearners() {
        return learners;
    }

    public void addLearner(Learner learner) {
        learners.add(learner);
    }

    public void removeLearner(Learner learner) {
        learners.remove(learner);
    }

    public int getMonth() {
        return month;
    }

    public String getTime() {
        return time;
    }
    @Override
    public String toString() {
        return "Lesson ID: " + id + ", Day: " + day + ", Time: " + time + ", Grade: " + grade + ", Coach: " + coach.getName();
    }

	// Inside the SwimmingLesson class
    public boolean isLearnerBooked(int learnerId) {
    for (Learner learner : learners) {
        if (learner.getId() == learnerId) {
            return true;
        }
    }
    return false;
}

}
