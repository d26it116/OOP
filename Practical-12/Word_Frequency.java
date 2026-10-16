import java.util.*;

class Main {
    public static void main(String[] args) {
        String paragraph = "java is easy java is powerful";

        String[] words = paragraph.split(" ");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> map.get(b) - map.get(a));

        for (String word : list) {
            System.out.println(word + " : " + map.get(word));
        }
    }
}