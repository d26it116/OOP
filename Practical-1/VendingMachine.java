
import java.util.Scanner;

// Enum to store the available coin types.
enum Coin {
    ONE, TWO, FIVE, TEN
}

public class VendingMachine {

    public static void main(String[] args) {
        int total = 0;
        Scanner sc = new Scanner(System.in);

     // Keep asking for coins until payment is complete.
    while(true) {

        System.out.print("Enter coin (ONE, TWO, FIVE, TEN): ");
        Coin coin;

          // Try to convert user input into a valid coin
        try {
                coin = Coin.valueOf(sc.next().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("  Not a valid coin, try again.");
                continue;
            }
        

        int value = switch (coin) {
            case ONE -> 1;
            case TWO -> 2;
            case FIVE -> 5;
            case TEN -> 10;
        };
       
        total += value;

    
        if (total <15 ) {
            System.out.println("  Inserted so far: " + total);
            
        }
        else {
            System.out.println("Paid. Change: " + (total - 15));
            break;
        }   
        
        // sc.close();
    }
}
}