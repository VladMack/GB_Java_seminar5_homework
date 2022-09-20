import java.util.*;
import java.util.HashMap;

public class homework1 {
    public static void main(String[] args) {
        String pushkin = "Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись";
        System.out.println(getSortedMap(pushkin).values());
    }

    public static Map getSortedMap (String str) {
        Map<Integer, ArrayList<String>> sortedMap = new TreeMap<>();
        String[] strArr = str.split(" ");
        for (String word : strArr) {
            if (sortedMap.containsKey(word.length())) {
            } else {
                sortedMap.put(word.length(), new ArrayList<>());
            }
            sortedMap.get(word.length()).add(word);
        }
        return sortedMap;
    }
}