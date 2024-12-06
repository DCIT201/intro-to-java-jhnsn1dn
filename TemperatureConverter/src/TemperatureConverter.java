import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = getValidChoice(scan); // Get a valid choice from the user (either 1 or 2)

        // Check the user's choice and call the appropriate conversion method
        if (choice == 1) {
            convertFahrenheitToCelsius(scan); // Call method to convert Fahrenheit to Celsius
        } else if (choice == 2) {
            convertCelsiusToFahrenheit(scan); // Call method to convert Celsius to Fahrenheit
        }

        scan.close(); // This closes the scanner to prevent resource leaks
    }

    // Method to convert Fahrenheit to Celsius
    private static void convertFahrenheitToCelsius(Scanner scan) {
        System.out.println("FAHRENHEIT to CELSIUS conversion");
        double F = getValidTemperature(scan, "Fahrenheit"); // Get a valid temperature in Fahrenheit
        double C = (F - 32) * 5 / 9; // Calculate Celsius
        System.out.println("Celsius value = " + Math.round(C * 10.0) / 10.0); // Print rounded Celsius value
    }

    // Method to convert Celsius to Fahrenheit
    private static void convertCelsiusToFahrenheit(Scanner scan) {
        System.out.println("CELSIUS to FAHRENHEIT conversion");
        double C = getValidTemperature(scan, "Celsius"); // Get a valid temperature in Celsius
        double F = (C * 9 / 5) + 32; // Calculate Fahrenheit
        System.out.println("Fahrenheit value = " + Math.round(F * 10.0) / 10.0 + " degrees Fahrenheit"); // Print rounded Fahrenheit value
    }

    // Method to get a valid choice from the user
    private static int getValidChoice(Scanner scan) {
        int choice = 0; // Variable to store the user's choice
        boolean valid = false; // Variable to track if the input is valid

        // Continue looping until valid is true
        while (!valid) { // This checks if valid is false
            System.out.print("Enter your choice (1 for Fahrenheit to Celsius, 2 for Celsius to Fahrenheit): "); // Prompt the user for input
            if (scan.hasNextInt()) { // Check if the input is an integer
                choice = scan.nextInt(); // Read the integer input
                if (choice == 1 || choice == 2) { // Validate the choice
                    valid = true; // Set valid to true to exit the loop
                } else {
                    System.out.println("Invalid choice. Please enter 1 or 2."); // Inform the user of invalid input
                }
            } else {
                System.out.println("Invalid input. Please enter a number."); // Inform the user of invalid input
                scan.next(); // Clear the invalid input
            }
        }
        return choice; // Return the valid choice
    }

    // Method to get a valid temperature input from the user
    private static double getValidTemperature(Scanner scan, String scale) {
        double temperature = 0; // Variable to store the temperature
        boolean valid = false; // Variable to track if the input is valid

        // Continue looping until valid is true
        while (!valid) {
            System.out.print("Enter a temperature value in " + scale + ": "); // Prompt the user for temperature input
            if (scan.hasNextDouble()) { // Check if the input is a double
                temperature = scan.nextDouble(); // Read the double input
                valid = true; // Set valid to true to exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid temperature."); // Inform the user of invalid input
                scan.next(); // Clear the invalid input
            }
        }
        return temperature; // Return the valid temperature
    }
}