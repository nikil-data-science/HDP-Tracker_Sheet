import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanEMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Loan EMI Calculator (CLI)");
        System.out.println("--------------------------------");

        double principal = readPositiveDouble(scanner, "Enter principal loan amount: ");
        double annualRate = readNonNegativeDouble(scanner, "Enter annual interest rate (in %): ");
        double years = readPositiveDouble(scanner, "Enter loan tenure (in years): ");

        double monthlyRate = annualRate / 1200.0;
        double months = years * 12;
        double emi;

        if (monthlyRate == 0) {
            emi = principal / months;
        } else {
            double factor = Math.pow(1 + monthlyRate, months);
            emi = principal * monthlyRate * factor / (factor - 1);
        }

        double totalPayment = emi * months;
        double totalInterest = totalPayment - principal;

        System.out.println();
        System.out.printf("Monthly EMI: %.2f%n", emi);
        System.out.printf("Total interest payable: %.2f%n", totalInterest);
        System.out.printf("Total payment amount: %.2f%n", totalPayment);
        scanner.close();
    }

    private static double readPositiveDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                if (value > 0) {
                    return value;
                }
                System.out.println("Please enter a positive number.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        double value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                if (value >= 0) {
                    return value;
                }
                System.out.println("Please enter a non-negative number.");
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }
}