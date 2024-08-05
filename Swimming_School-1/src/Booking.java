public class Booking {
    private static int nextId = 1;

    private int id;
    private SwimmingLesson lesson;
    private Learner learner;
    private String status;
    private int rating;
    private String review;

    public Booking(SwimmingLesson lesson, Learner learner) {
        this.id = nextId++;
        this.lesson = lesson;
        this.learner = learner;
        this.status = "booked";
        this.rating = -1; 
        this.review = ""; 
    }

    public int getId() {
        return id;
    }

    public SwimmingLesson getLesson() {
        return lesson;
    }

    public void setLesson(SwimmingLesson lesson) {
        this.lesson = lesson;
    }

    public Learner getLearner() {
        return learner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    
    public boolean isCancelled() {
        return status.equals("cancelled");
    }

    public boolean isAttended() {
        return status.equals("attended");
    }

    @Override
    public String toString() {
        return "Booking ID: " + id + ", Lesson: " + lesson.getId() + ", Learner: " + learner.getName() + ", Status: " + status;
    }
}


