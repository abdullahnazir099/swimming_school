import java.util.ArrayList;


import java.util.List;


public class Learner {
    private static int nextId = 1;

    private int id;
    private String name;
    private String gender;
    private int age;
    private String emergencyContact;
    private int gradeLevel;
    private List<Booking> bookings;

    public Learner(String name, String gender, int age, String emergencyContact, int gradeLevel) {
        this.id = nextId++;
        this.name = name;
        this.setGender(gender);
        this.setAge(age);
        this.setEmergencyContact(emergencyContact);
        this.gradeLevel = gradeLevel;
        this.bookings = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void cancelBooking(Booking booking) {
        bookings.remove(booking);
    }
    

    @Override
    public String toString() {
        return "Learner ID: " + id + ", Name: " + name + ", Grade Level: " + getGradeLevel();
    }

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public String getGender() {
		
		return gender;
	}

	public int getAge() {
		
		return age;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
}
