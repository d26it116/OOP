import java.lang.Exception;

// class InsufficientBalanceException extends Exception {

//     public InsufficientBalanceException(String message) {
//         super(message);
//     }
    
// }

// class Banking {
//     static void withdraw(double balance , double amount)
//     throws InsufficientBalanceException{
//         if (balance < amount){
//                 throw new InsufficientBalanceException("insufficient");
//         }
//          System.out.println("Withdrawal successful");
//     }

//     public static void main(String[] args) {
//         try {
//             withdraw(3000, 5000);
//         } catch (InsufficientBalanceException e) {

//         System.out.println(e.getMessage());
//         }
//         finally {
//             System.out.println("Transaction completed");
//         }
//     }
// }


// class InvalidMarksException extends Exception{

//     public InvalidMarksException(String message) {
//         super(message);
//     }
    
// }

// class MarksChecker{
//     static void marks(int marks) throws InvalidMarksException{
//         if(marks < 0 || marks > 100){
//             throw new InvalidMarksException("Please enter marks between 1 to 100");

//         }
//         System.out.println("marks:-"+marks);
//     }

//     public static void main(String[] args) {
//         try {
//             marks(19);
//         } catch (InvalidMarksException e) {
//             System.out.println(e.getMessage());
//         }
//         finally{
//             System.out.print("Thanks");
//         }
//     }
// }

// import java.io.*;

// class Main {

//     public static void main(String[] args) {

//         try {
//             FileReader file =
//                 new FileReader("employee.txt");

//             System.out.println("File opened successfully");

//             file.close();
//         }
//         catch (FileNotFoundException e) {
//             System.out.println("Employee file not found");
//         }
//         catch (IOException e) {
//             System.out.println("Error while closing file");
//         }
//     }
// }

import java.io.*;

class main {

    public static void main(String[] args) {

        try (FileReader file =
                new FileReader("employee.txt")) {

            System.out.println("File opened");

        }
        catch (IOException e) {
            System.out.println("File handling error");
        }
    }
}


