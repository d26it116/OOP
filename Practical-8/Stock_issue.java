class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        this.shortfall = shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException(String message) {
        super(message);
    }
}

class Warehouse {
    int stock = 50;

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException("Invalid quantity");
        }

        if (qty > stock) {
            throw new OutOfStockException(qty - stock);
        }

        stock = stock - qty;
        System.out.println(item + " issued: " + qty);
    }
}

public class Stock_issue{
    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        String[] items = {"Laptop", "Mouse", "Keyboard", "Monitor"};
        int[] qty = {20, 15, 25, 0};

        for (int i = 0; i < items.length; i++) {

            try {
                w.issue(items[i], qty[i]);

            } catch (OutOfStockException e) {
                System.out.println(items[i] +
                        " failed. Shortfall: " + e.shortfall);

            } catch (InvalidQuantityException e) {
                System.out.println(items[i] +
                        " failed. " + e.getMessage());
            }
        }

        System.out.println("All requests processed.");
    }
}