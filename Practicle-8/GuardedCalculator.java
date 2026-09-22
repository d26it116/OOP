import java.util.Scanner;

// Custom exception
class DivideByZeroException extends Exception {
    public DivideByZeroException(String message) {
        super(message);
    }
}

public class GuardedCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter first number: ");
                double num1 = Double.parseDouble(sc.nextLine());

                System.out.print("Enter operator (+, -, *, /): ");
                char op = sc.nextLine().charAt(0);

                System.out.print("Enter second number: ");
                double num2 = Double.parseDouble(sc.nextLine());

                double result;

                switch (op) {
                    case '+':
                        result = num1 + num2;
                        break;

                    case '-':
                        result = num1 - num2;
                        break;

                    case '*':
                        result = num1 * num2;
                        break;

                    case '/':
                        if (num2 == 0) {
                            throw new DivideByZeroException(
                                "Cannot divide by zero."
                            );
                        }
                        result = num1 / num2;
                        break;

                    default:
                        System.out.println("Invalid operator.");
                        continue;
                }

                System.out.println("Result = " + result);

                // Valid calculation → stop loop
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please enter numeric values.");

            } catch (DivideByZeroException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Attempt logged.");
                System.out.println("--------------------");
            }
        }

        sc.close();
    }
}