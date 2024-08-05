
public class Rating {
    private int value;
    private int month;

    public Rating(int value, int month) {
        this.value = value;
        this.month = month;
    }

    public int getValue() {
        return value;
    }

    public int getMonth() {
        return month;
    }
}