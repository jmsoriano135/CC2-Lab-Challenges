//Soriano, JM P.
//CITCS1N
//Final Challenge No. 3: University Course Enrollment and Grades Tracker (1D and 2D arrays)

import java.util.Scanner;

public class GradeTracker{
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        // Array to store names of 5 students
        String[] studentNames = new String[5];
        
        // Two-dimensional array to store grades for each student in 3 subjects
        double[][] grades = new double[5][3];
        
        // Step 1: Input student names
        System.out.println("Enter the names of 5 students:");
        for (int i = 0; i < studentNames.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            studentNames[i] = scanner.nextLine();
        }

        // Step 2: Input grades for each student
        for (int i = 0; i < studentNames.length; i++) {
            System.out.println("Enter grades for " + studentNames[i] + ":");
            for (int j = 0; j < grades[i].length; j++) {
                System.out.print("Grade for subject " + (j + 1) + ": ");
                grades[i][j] = scanner.nextDouble();
            }
            scanner.nextLine(); // Consume newline left-over
        }

        // Step 3: Calculate and display average grades
        System.out.println("\nAverage Grades:");
        for (int i = 0; i < studentNames.length; i++) {
            double average = calculateAverage(grades[i]); // Calculate average for each student
            System.out.println(studentNames[i] + "'s average grade: " + average);
        }

        scanner.close(); // Close the scanner
    }

    // Method to calculate the average grade of a student
    private static double calculateAverage(double[] grades) {
        double sum = 0; // Initialize sum to zero
        
        // Sum up all the grades
        for (double grade : grades) {
            sum += grade;
        }
        
        // Calculate average by dividing sum by number of grades
        return sum / grades.length;
    }
}