package StringAndArray;

import java.sql.ClientInfoStatus;
import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {

        String[] list = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(list));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0)
            return result;
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            System.out.println("str: " + str);
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            System.out.println(charArray);
            String key = String.valueOf(charArray);
            System.out.println("key " + key);

            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        result.addAll(map.values());
        return result;
    }
}
