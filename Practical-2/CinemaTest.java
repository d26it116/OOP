class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;

    CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    CinemaShow(String title) {
        this(title, 100);
    }

    boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    void cancel(int n) {
        int bookedSeats = capacity - seatsAvailable;

        if (n <= bookedSeats) {
            seatsAvailable += n;
            totalBooked -= n;
        }
    }
    int getSeatsAvailable() {
        return seatsAvailable;
    }

    static int getTotalBooked() {
        return totalBooked;
    }
}

public class CinemaTest {
    public static void main(String[] args) {

        CinemaShow userA = new CinemaShow("Show A", 5);

        if (userA.book(3))
            System.out.println("User A) -> booked 3 | remaining "
                    + userA.getSeatsAvailable());

        if (userA.book(1))
            System.out.println("User A) -> booked 1 | remaining "
                    + userA.getSeatsAvailable());

        boolean result = userA.book(3);
        System.out.println("User A) -> booked 3 -> " + result
                + " | remaining " + userA.getSeatsAvailable());

        userA.cancel(1);
        System.out.println("User A) -> cancel 1 | remaining "
                + userA.getSeatsAvailable());

        CinemaShow userB = new CinemaShow("Show B");

        if (userB.book(5))
            System.out.println("User B) -> booked 5 | remaining "
                    + userB.getSeatsAvailable());

        System.out.println();
        System.out.println("Total Booking -> "
                + CinemaShow.getTotalBooked());
    }
}