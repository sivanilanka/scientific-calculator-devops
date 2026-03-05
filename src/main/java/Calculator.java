import java.util.Scanner;

public class Calculator {

    public static double sqrt(double x) {
        return Math.sqrt(x);
    }

    public static long factorial(int n) {
        long result = 1;
        for(int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static double ln(double x) {
        return Math.log(x);
    }

    public static double power(double a, double b) {
        return Math.pow(a, b);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.println("\nScientific Calculator");
            System.out.println("1. Square Root");
            System.out.println("2. Factorial");
            System.out.println("3. Natural Log");
            System.out.println("4. Power");
            System.out.println("5. Exit");

            System.out.print("Choose option: ");
            int choice = scanner.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter number: ");
                    double num = scanner.nextDouble();
                    System.out.println("Result: " + sqrt(num));
                    break;

                case 2:
                    System.out.print("Enter integer: ");
                    int n = scanner.nextInt();
                    System.out.println("Result: " + factorial(n));
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double x = scanner.nextDouble();
                    System.out.println("Result: " + ln(x));
                    break;

                case 4:
                    System.out.print("Enter base: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    double b = scanner.nextDouble();
                    System.out.println("Result: " + power(a,b));
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
