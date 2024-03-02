import java.util.Scanner;

public class StudentResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Take marks obtained in each subject
        System.out.println("Enter marks obtained in each subject (out of 100):");
        int numSubjects = 0;
        int totalMarks = 0;

        while (true) {
            System.out.print("Subject " + (numSubjects + 1) + ": ");
            int marks = scanner.nextInt();

            // Break the loop if the user enters a negative value
            if (marks < 0) {
                break;
            }

            totalMarks += marks;
            numSubjects++;
        }

        // Calculate Total Marks
        System.out.println("Total Marks: " + totalMarks);

        // Calculate Average Percentage
        if (numSubjects > 0) {
            double averagePercentage = (double) totalMarks / numSubjects;
            System.out.println("Average Percentage: " + averagePercentage + "%");

            // Grade Calculation
            char grade = calculateGrade(averagePercentage);
            System.out.println("Grade: " + grade);
        } else {
            System.out.println("No subjects entered. Unable to calculate average and grade.");
        }
    }

    // Grade Calculation Method
    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
