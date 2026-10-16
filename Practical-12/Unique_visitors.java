import java.util.*;

class Main {
    public static void main(String[] args) {
        String[] users = {"Amit", "Rahul", "Amit", "Jay", "Rahul", "Priya"};

        HashSet<String> set = new HashSet<>(Arrays.asList(users));
        LinkedHashSet<String> order = new LinkedHashSet<>(Arrays.asList(users));

        System.out.println("Unique count: " + set.size());

        int count = 0;
        for (String name : order) {
            if (count == 3) {
                break;
            }
            System.out.println(name);
            count++;
        }
    }
}