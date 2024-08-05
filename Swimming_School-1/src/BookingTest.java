
import org.junit.Test;
import static org.junit.Assert.*;

public class BookingTest {

    @Test
    public void testBookingStatus() {
        Coach coach = new Coach("Helen");
        SwimmingLesson lesson = new SwimmingLesson("Monday", "Monday", 1, coach);
        Learner learner = new Learner("Alice", "Female", 8, "1234567890", 1);
        Booking booking = new Booking(lesson, learner);

        assertEquals("booked", booking.getStatus());  // Initially booked



    }
}

