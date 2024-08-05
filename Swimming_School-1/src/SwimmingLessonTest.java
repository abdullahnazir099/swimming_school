import org.junit.Test;
import static org.junit.Assert.*;

public class SwimmingLessonTest {

    @Test
    public void testAddLearner() {
        Coach coach = new Coach("Helen");
        SwimmingLesson lesson = new SwimmingLesson("Monday", "Monday", 1, coach);
        Learner learner1 = new Learner("Alice", "Female", 8, "1234567890", 1);
        Learner learner2 = new Learner("Bob", "Male", 7, "9876543210", 1);

        // Adding a learner to the lesson
        lesson.addLearner(learner1);
        assertEquals(1, lesson.getLearners().size());
        assertTrue(lesson.getLearners().contains(learner1));

        // Adding another learner to the same lesson
        lesson.addLearner(learner2);
        assertEquals(2, lesson.getLearners().size());
        assertTrue(lesson.getLearners().contains(learner2));
    }

    @Test
    public void testRemoveLearner() {
        Coach coach = new Coach("Helen");
        SwimmingLesson lesson = new SwimmingLesson("Monday", "Monday", 1, coach);
        Learner learner1 = new Learner("Alice", "Female", 8, "1234567890", 1);
        Learner learner2 = new Learner("Bob", "Male", 7, "9876543210", 1);

        // Adding learners
        lesson.addLearner(learner1);
        lesson.addLearner(learner2);
        assertEquals(2, lesson.getLearners().size());

        // Removing a learner
        lesson.removeLearner(learner1);
        assertEquals(1, lesson.getLearners().size());
        assertFalse(lesson.getLearners().contains(learner1));

        // Removing a non-existent learner
        lesson.removeLearner(learner1);  
        assertEquals(2, lesson.getLearners().size());  
    }
}
