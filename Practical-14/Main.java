import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemService service = new ItemService();

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. Show Count");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    service.addItem(sc.nextLine());
                    break;

                case 2:
                    System.out.println("Count: " + service.getCount());
                    break;

                case 3:
                    return;

                default:
                    throw new IllegalArgumentException("Invalid action");
            }
        }
    }
}