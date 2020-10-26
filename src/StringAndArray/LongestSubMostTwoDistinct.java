package StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class LongestSubMostTwoDistinct {
    public static void main(String[] args) {
        String s = "ccaabbb";
        System.out.println(solve(s));
    }

    public static int solve(String s) {
        int start = 0, end = 0, length = 0, counter = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (end < s.length()) {
            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);
            if (map.get(endChar) == 1) counter++;
            end++;

            while (counter > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if (map.get(startChar) == 0) counter--;
                start++;
            }

            length = Math.max(length, end - start);
        }
        return length;
    }
}
