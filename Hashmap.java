import java.awt.*;
import java.util.*;
import java.util.List;

public class Hashmap {
    private static Map<String, String> dictionary;
    public static void main(String[] args) {
        dictionary = new HashMap<String, String>();
        Set<String> set = dictionary.keySet();
        dictionary.put("xin chao", "hello");
        dictionary.put("con cho", "dog");
        dictionary.put("con meo", "cat");
        dictionary.put("con chim", "bird");
        dictionary.put("con ca", "fish");
        dictionary.put("con tho", "rabbit");
//        System.out.println(dictionary.get("rabbit"));
//        System.out.println(dictionary.entrySet().getClass());
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        while (s != "Exit") {
            if (dictionary.containsKey(s))
               System.out.println(dictionary.get(s));
            else if (dictionary.containsValue(s))
                for (Map.Entry<String,String> s1: dictionary.entrySet()) {
                    if (s1.getValue().equals(s))
                        System.out.println(s1.getKey());
                }
            else System.out.println("k thay!");
            s = sc.nextLine();
        }
    }
}
