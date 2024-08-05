
import java.util.*;
import java.util.Scanner;



public class SwimmingSchool {
    private List<SwimmingLesson> timetable;
    private List<Coach> coaches;
    private List<Learner> learners;
    private int bookingIdCounter;

    public SwimmingSchool() {
        this.timetable = new ArrayList<>();
        this.coaches = new ArrayList<>();
        this.learners = new ArrayList<>();
        this.bookingIdCounter = 1;
        initializeData();
    }

    
    private void initializeData() {
     
        Coach coach1 = new Coach("Helen");
        Coach coach2 = new Coach("John");
        Coach coach3 = new Coach("Emma");
        coaches.add(coach1);
        coaches.add(coach2);
        coaches.add(coach3);
        
        Learner learner1 = new Learner("Alice", "Female", 10, "1234567890", 1);
        Learner learner2 = new Learner("Bob", "Male", 8, "0987654321", 2);
        Learner learner3 = new Learner("Ethan", "Male", 6, "0887645321", 1);
        Learner learner4 = new Learner("Henry", "Male", 9, "1234567890", 2);
        Learner learner5 = new Learner("June", "Female", 11, "0987654321", 1);
        Learner learner6 = new Learner("David", "Male", 6, "0887645321", 3);
        Learner learner7 = new Learner("Steve", "Male", 7, "1234567890", 3);
        Learner learner8 = new Learner("Hannah", "Female", 8, "0987654321", 4);
        Learner learner9 = new Learner("Bruce", "Male", 9, "0887645321", 4);
        Learner learner10 = new Learner("Nina", "Female", 10, "1234567890", 2);
        Learner learner11 = new Learner("Kevin", "Male", 5, "0987654321", 2);
        Learner learner12 = new Learner("Emily", "Female", 4, "0887645321", 3);
        
        learners.add(learner1);
        learners.add(learner2);
        learners.add(learner3);
        learners.add(learner4);
        learners.add(learner5);
        learners.add(learner6);
        learners.add(learner7);
        learners.add(learner8);
        learners.add(learner9);
        learners.add(learner10);
        learners.add(learner11);
        learners.add(learner12);

     
        createTimetable();
    }

    private void createTimetable() {
      
        for (int week = 1; week <= 4; week++) {
            for (String day : new String[]{"Monday", "Wednesday", "Friday", "Saturday"}) {
                for (String time : new String[]{"4-5pm", "5-6pm", "6-7pm"}) {
                    for (int gradeLevel = 1; gradeLevel <= 5; gradeLevel++) {
                        Random random = new Random();
                        Coach coach = coaches.get(random.nextInt(coaches.size()));
                        SwimmingLesson lesson = new SwimmingLesson(day, time, gradeLevel, coach);
                  
                        timetable.add(lesson);
                    }
                }
            }
        }
    }

    public void bookLesson(Scanner scanner) {
        System.out.println("How would you like to view the timetable?");
        System.out.println("1. By specifying the day");
        System.out.println("2. By specifying the grade level");
        System.out.println("3. By specifying the coach's name");
        System.out.print("Enter your choice: ");

        int option = scanner.nextInt();
        scanner.nextLine();  

        List<SwimmingLesson> lessons = new ArrayList<>();
        switch (option) {
            case 1:
                System.out.print("Enter the day (e.g., Monday): ");
                String day = scanner.nextLine();
                lessons = findLessons(day, 1);
                break;
            case 2:
                System.out.print("Enter the grade level (1-5): ");
                int gradeLevel = scanner.nextInt();
                scanner.nextLine();  
                lessons = findLessons(Integer.toString(gradeLevel), 2);
                break;
            case 3:
                System.out.print("Enter the coach's name: ");
                String coachName = scanner.nextLine();
                lessons = findLessons(coachName, 3);
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        if (!lessons.isEmpty()) {
            System.out.println("Available Lessons:");
            for (SwimmingLesson lesson : lessons) {
                System.out.println(lesson);
            }

            System.out.print("Enter the lesson ID to book: ");
            int lessonId = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            SwimmingLesson selectedLesson = findLessonById(lessonId);
            if (selectedLesson != null) {
                System.out.print("Enter your learner ID: ");
                int learnerId = scanner.nextInt();
                scanner.nextLine(); 

                Learner learner = findLearnerById(learnerId);
                if (learner != null) {
                    // Check if the learner is already booked for this lesson
                    if (selectedLesson.isLearnerBooked(learnerId)) {
                        System.out.println("You have already booked this lesson.");
                        return;
                    }
                    
                    // Check if the lesson has vacancies
                    if (selectedLesson.getLearners().size() >= 4) {
                        System.out.println("This lesson is full. Please choose another one.");
                        return;
                    }

                    int a =  selectedLesson.getGrade() ;
                    a=a-1;
                    // Check if the learner's grade allows booking this lesson
                    if (learner.getGradeLevel() == selectedLesson.getGrade() )
                    {
                    	  Booking booking = new Booking(selectedLesson, learner);
                          learner.addBooking(booking);
                          selectedLesson.addLearner(learner);
                          System.out.println("Booking successful!");
                       
                    	
                    }
                    else if (learner.getGradeLevel() == a)
                    {
                  	  Booking booking = new Booking(selectedLesson, learner);
                        learner.addBooking(booking);
                        selectedLesson.addLearner(learner);
                        System.out.println("Booking successful!");
                    
                     }
                    else {
                  	  System.out.println("You can only book lessons of your grade level or one grade level higher.");
                    }
                 
                 
                }
            } else {
                System.out.println("Lesson not found.");
            }
        } 
        else {
            System.out.println("No lessons available.");
        }
    }


    public void changeOrCancelBooking(Scanner scanner) {
        System.out.print("Enter your learner ID: ");
        int learnerId = scanner.nextInt();
        scanner.nextLine();

        Learner learner = findLearnerById(learnerId);
        if (learner != null) {
            List<Booking> bookings = learner.getBookings();
            if (!bookings.isEmpty()) {
                System.out.println("Your Bookings:");
                for (Booking booking : bookings) {
                    System.out.println(booking);
                }

                System.out.print("Enter the booking ID to change/cancel: ");
                int bookingId = scanner.nextInt();
                scanner.nextLine();  

                Booking selectedBooking = findBookingById(bookingId, bookings);
                if (selectedBooking != null) {
                    System.out.println("1. Change Booking");
                    System.out.println("2. Cancel Booking");
                    System.out.print("Enter your choice: ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();  

                    switch (choice) {
                        case 1:
                            List<SwimmingLesson> lessons = new ArrayList<>();
                            System.out.println("How would you like to view the timetable?");
                            System.out.println("1. By specifying the day");
                            System.out.println("2. By specifying the grade level");
                            System.out.println("3. By specifying the coach's name");
                            System.out.print("Enter your choice: ");
                            int option = scanner.nextInt();
                            scanner.nextLine(); 

                            switch (option) {
                                case 1:
                                    System.out.print("Enter the day (e.g., Monday): ");
                                    String day = scanner.nextLine();
                                    lessons = findLessons(day, 1);
                                    break;
                                case 2:
                                    System.out.print("Enter the grade level (1-5): ");
                                    int gradeLevel = scanner.nextInt();
                                    scanner.nextLine();  
                                    lessons = findLessons(Integer.toString(gradeLevel), 2);
                                    break;
                                case 3:
                                    System.out.print("Enter the coach's name: ");
                                    String coachName = scanner.nextLine();
                                    lessons = findLessons(coachName, 3);
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                                    return;
                            }

                            if (!lessons.isEmpty()) {
                                System.out.println("Available Lessons:");
                                for (SwimmingLesson lesson : lessons) {
                                    System.out.println(lesson);
                                }

                                System.out.print("Enter the new lesson ID to book: ");
                                int newLessonId = scanner.nextInt();
                                scanner.nextLine(); 

                                SwimmingLesson newLesson = findLessonById(newLessonId);
                                if (newLesson != null) {
                                    selectedBooking.setLesson(newLesson);
                                    newLesson.addLearner(learner);
                                    System.out.println("Booking changed successfully!");
                                } else {
                                    System.out.println("Lesson not found.");
                                }
                            } else {
                                System.out.println("No lessons available.");
                            }
                            break;
                        case 2:
                            learner.cancelBooking(selectedBooking);
                            selectedBooking.getLesson().removeLearner(learner);
                            System.out.println("Booking cancelled successfully!");
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            break;
                    }
                } else {
                    System.out.println("Booking not found.");
                }
            } else {
                System.out.println("No bookings to change/cancel.");
            }
        } else {
            System.out.println("Learner not found.");
        }
    }

    public void attendLesson(Scanner scanner) {
        System.out.print("Enter your learner ID: ");
        int learnerId = scanner.nextInt();
        scanner.nextLine(); 

        Learner learner = findLearnerById(learnerId);
        if (learner != null) {
            List<Booking> bookings = learner.getBookings();
            if (!bookings.isEmpty()) {
                System.out.println("Your Bookings:");
                for (Booking booking : bookings) {
                    System.out.println(booking);
                }

                System.out.print("Enter the booking ID to attend: ");
                int bookingId = scanner.nextInt();
                scanner.nextLine();  

                Booking selectedBooking = findBookingById(bookingId, bookings);
                if (selectedBooking != null) {
                    if (selectedBooking.getStatus().equals("attended")) {
                        System.out.println("You have already attended this lesson.");
                    } else {
                        System.out.print("Enter your rating for the lesson (1-5): ");
                        int rating = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Write a review for the lesson: ");
                        String review = scanner.nextLine();

                        selectedBooking.setStatus("attended");
                        selectedBooking.setRating(rating);
                        selectedBooking.setReview(review);

                        // Update learner's grade level
                        int currentGrade = learner.getGradeLevel();
                        if (rating >= 4 && currentGrade < 5) {
                            learner.setGradeLevel(currentGrade + 1);
                            System.out.println("Congratulations! Your grade level has been increased to " + (currentGrade + 1));
                        }
                        
                        SwimmingLesson lesson = selectedBooking.getLesson();
                        Coach coach = lesson.getCoach();
                        if (coach != null) {
                            coach.addRating(new Rating(rating, lesson.getMonth()));
                        }

                        System.out.println("Lesson attended and rated successfully!");
                    }
                } else {
                    System.out.println("Booking not found.");
                }
            } else {
                System.out.println("No bookings to attend.");
            }
        } else {
            System.out.println("Learner not found.");
        }
    }


    public void monthlyLearnerReport() {
        for (Learner learner : learners) {
            System.out.println("\nMonthly Learner Report for " + learner.getName() + ":");
            System.out.println("Learner Details:");
            System.out.println("ID: " + learner.getId());
            System.out.println("Name: " + learner.getName());
            System.out.println("Gender: " + learner.getGender());
            System.out.println("Age: " + learner.getAge());
            System.out.println("Emergency Contact: " + learner.getEmergencyContact());
            
            int grade = learner.getGradeLevel();

            System.out.println("\nLessons:");
            int bookedCount = 0;
            int cancelledCount = 0;
            int attendedCount = 0;
            for (Booking booking : learner.getBookings()) {
                SwimmingLesson lesson = booking.getLesson();
                System.out.println("Lesson ID: " + lesson.getId());
                System.out.println("Day: " + lesson.getDay());
                System.out.println("Time: " + lesson.getTime());
                System.out.println("Grade Level: " + lesson.getGrade());
                System.out.println("Coach: " + lesson.getCoach().getName());
                System.out.println("Status: " + booking.getStatus());
                System.out.println("----------------------");
                
                String status = booking.getStatus();
                if (status.equals("booked")) {
                    bookedCount++;
                } else if (status.equals("cancelled")) {
                    cancelledCount++;
                } else if (status.equals("attended")) {
                    attendedCount++;
                }
            }
            System.out.println("Number of lessons booked: " + bookedCount);
            System.out.println("Number of lessons cancelled: " + cancelledCount);
            System.out.println("Number of lessons attended: " + attendedCount);
            System.out.println("Learner's Grade: " + grade);
        }
    }





    public void monthlyCoachReport() {
        System.out.println("\nMonthly Coach Report:");
        
        for (Coach coach : coaches) {
            System.out.println("Coach: " + coach.getName());
            double averageRating = coach.getAverageRating();
            if (averageRating >= 0) {
                System.out.println("Average Rating: " + averageRating);
            } else {
                System.out.println("No ratings available for this coach.");
            }
            System.out.println("----------------------");
        }
    }



    public void registerNewLearner(Scanner scanner) {
        int learnerId = learners.size() + 1;
        System.out.println("Your learner ID is: " + learnerId); 
        
        System.out.print("Enter learner's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter learner's gender: ");
        String gender = scanner.nextLine();

        int age;
        // Prompt the user until a valid age (between 4-11) is provided
        while (true) {
            System.out.print("Enter learner's age (4-11): ");
            age = scanner.nextInt();
            scanner.nextLine();  
            if (age >= 4 && age <= 11) {
                break;  // Exit the loop if age is valid
            } else {
                System.out.println("Age must be between 4-11.");
            }
        }

        System.out.print("Enter emergency contact phone number: ");
        String emergencyContact = scanner.nextLine();

        int gradeLevel;
        // Prompt the user until a valid grade level (between 0-5) is provided
        while (true) {
            System.out.print("Enter learner's grade level (0-5): ");
            gradeLevel = scanner.nextInt();
            scanner.nextLine();  
            if (gradeLevel >= 0 && gradeLevel <= 5) {
                break;  // Exit the loop if grade level is valid
            } else {
                System.out.println("Grade level must be between 0-5.");
            }
        }

        Learner learner = new Learner(name, gender, age, emergencyContact, gradeLevel);
        learners.add(learner);

        System.out.println("New learner registered successfully!");
    }


  
    private SwimmingLesson findLessonById(int lessonId) {
        for (SwimmingLesson lesson : timetable) {
            if (lesson.getId() == lessonId) {
                return lesson;
            }
        }
        return null;
    }

    private Learner findLearnerById(int learnerId) {
        for (Learner learner : learners) {
            if (learner.getId() == learnerId) {
                return learner;
            }
        }
        return null;
    }

    private Booking findBookingById(int bookingId, List<Booking> bookings) {
        for (Booking booking : bookings) {
            if (booking.getId() == bookingId) {
                return booking;
            }
        }
        return null;
    }

    private List<SwimmingLesson> findLessons(String searchTerm, int searchType) {
        List<SwimmingLesson> foundLessons = new ArrayList<>();
        for (SwimmingLesson lesson : timetable) {
            switch (searchType) {
                case 1:  
                    if (lesson.getDay().equalsIgnoreCase(searchTerm)) {
                        foundLessons.add(lesson);
                    }
                    break;
                case 2:  
                    if (lesson.getGrade() == Integer.parseInt(searchTerm)) {
                        foundLessons.add(lesson);
                    }
                    break;
                case 3: 
                    if (lesson.getCoach().getName().equalsIgnoreCase(searchTerm)) {
                        foundLessons.add(lesson);
                    }
                    break;
            }
        }
        return foundLessons;
    }

    
}

