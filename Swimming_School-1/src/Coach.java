import java.util.ArrayList;
import java.util.List;

public class Coach {
    private String name;
    private List<Rating> ratings;

    public Coach(String name) {
        this.name = name;
        this.ratings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
    }


    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return -1; // Indicates no ratings available
        }
        
        int sum = 0;
        for (Rating rating : ratings) {
            sum += rating.getValue();
        }
        
        return (double) sum / ratings.size();
    }

}






