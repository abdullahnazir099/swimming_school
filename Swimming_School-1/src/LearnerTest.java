import org.junit.Test;
import static org.junit.Assert.*;

public class LearnerTest {

    @Test
    public void testAddBooking() {
        Learner learner = new Learner("Alice", "Female", 8, "1234567890", 1);
        Coach coach = new Coach("Helen");
        SwimmingLesson lesson1 = new SwimmingLesson("Monday", "Monday", 1, coach);
        SwimmingLesson lesson2 = new SwimmingLesson("Monday", "Monday", 1, coach);
        Booking booking1 = new Booking(lesson1, learner);
        Booking booking2 = new Booking(lesson2, learner);

        // Adding bookings
        learner.addBooking(booking1);
        assertEquals(1, learner.getBookings().size());
        assertTrue(learner.getBookings().contains(booking1));

        // Adding another booking
        learner.addBooking(booking2);
        assertEquals(2, learner.getBookings().size());
        assertTrue(learner.getBookings().contains(booking2));
    }

    @Test
    public void testRemoveBooking() {
        Learner learner = new Learner("Alice", "Female", 8, "1234567890", 1);
        Coach coach = new Coach("Helen");
        SwimmingLesson lesson1 = new SwimmingLesson("Monday", "Monday", 1, coach);
        SwimmingLesson lesson2 = new SwimmingLesson("Monday", "Monday", 1, coach);
        Booking booking1 = new Booking(lesson1, learner);
        Booking booking2 = new Booking(lesson2, learner);

        // Adding bookings
        learner.addBooking(booking1);
        learner.addBooking(booking2);
        assertEquals(2, learner.getBookings().size());

        // Removing a booking
        learner.cancelBooking(booking1);
        assertEquals(1, learner.getBookings().size());
        assertFalse(learner.getBookings().contains(booking1));

        // Removing a non-existent booking
        learner.cancelBooking(booking1);  
        assertEquals(1, learner.getBookings().size());  
    }
}
