//Soriano, JM P.
//CITCS1N
//Final Challenge No. 2: Weather Data Tracker (2D array)

import java.util.Scanner;

public class WeatherDataTracker {
    public static void main(String[] args) {
        // Constants for number of cities and days
        final int CITIES = 3;
        final int DAYS = 7;

        // Array to store temperature data
        double[][] temperatures = new double[CITIES][DAYS];

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Input temperature data
        for (int city = 0; city < CITIES; city++) {
            System.out.println("Enter temperatures for City " + (city + 1) + ":");
            for (int day = 0; day < DAYS; day++) {
                System.out.print("Day " + (day + 1) + ": ");
                temperatures[city][day] = scanner.nextDouble();
            }
        }

        // Calculating averages and highest temperatures
        for (int city = 0; city < CITIES; city++) {
            double totalTemperature = 0;
            double highestTemperature = Double.MIN_VALUE;

            for (int day = 0; day < DAYS; day++) {
                totalTemperature += temperatures[city][day];
                if (temperatures[city][day] > highestTemperature) {
                    highestTemperature = temperatures[city][day];
                }
            }

            double averageTemperature = totalTemperature / DAYS;

            // Output results
            System.out.printf("City %d: Average Temperature: %.2f, Highest Temperature: %.2f%n",
                    city + 1, averageTemperature, highestTemperature);
        }

        // Closing the scanner
        scanner.close();
    }
}