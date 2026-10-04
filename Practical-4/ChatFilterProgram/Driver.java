import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        String[] logs = {
            "10:05 Aaryan Hello there",
            "10:10 Ramesh How are you",
            "10:15 Aaryan I'm good, thanks",
        };

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        String result = ChatFilter.filterLogs(logs, keyword);

        System.out.println(result);

        sc.close();
    }
}