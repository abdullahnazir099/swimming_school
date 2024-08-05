import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class CoachTest {

    @Test
    public void testAddRating() {
        
        Coach coach = new Coach("John Doe");

       
        Rating rating1 = new Rating(5, 1);
        Rating rating2 = new Rating(4, 1);
        Rating rating3 = new Rating(3, 1);

       
        coach.addRating(rating1);
        coach.addRating(rating2);
        coach.addRating(rating3);

       
        List<Rating> expectedRatings = new ArrayList<>();
        expectedRatings.add(rating1);
        expectedRatings.add(rating2);
        expectedRatings.add(rating3);

        assertEquals(expectedRatings, coach.getRatings());
    }

    @Test
    public void testGetAverageRating() {
       
        Coach coach = new Coach("Jane Smith");

       
        coach.addRating(new Rating(5, 1));
        coach.addRating(new Rating(4, 1));
        coach.addRating(new Rating(3, 1));

      
        double averageRating = coach.getAverageRating();

     
        assertEquals(4.0, averageRating, 0.01);
    }

    @Test
    public void testGetAverageRatingNoRatings() {
      
        Coach coach = new Coach("Alice Johnson");

     
        double averageRating = coach.getAverageRating();

       
        assertEquals(-1, averageRating, 0.01);
    }
}
