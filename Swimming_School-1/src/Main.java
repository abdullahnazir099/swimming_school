import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            SwimmingSchool school = new SwimmingSchool();

            System.out.println("Welcome to Hatfield Junior Swimming School!");
            int choice = 0;
            while (choice != 7) {
                System.out.println("\nMenu:");
                System.out.println("1. Book a Swimming Lesson");
                System.out.println("2. Change/Cancel a Booking");
                System.out.println("3. Attend a Swimming Lesson");
                System.out.println("4. Monthly Learner Report");
                System.out.println("5. Monthly Coach Report");
                System.out.println("6. Register a New Learner");
                System.out.println("7. Exit");

                System.out.print("\nEnter your choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    switch (choice) {
                        case 1:
                            school.bookLesson(scanner);
                            break;
                        case 2:
                            school.changeOrCancelBooking(scanner);
                            break;
                        case 3:
                            school.attendLesson(scanner);
                            break;
                        case 4:
                            school.monthlyLearnerReport();
                            break;
                        case 5:
                            school.monthlyCoachReport();
                            break;
                        case 6:
                            school.registerNewLearner(scanner);
                            break;
                        case 7:
                            System.out.println("Exiting...");
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                            break;
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();  // Clear the invalid input
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
