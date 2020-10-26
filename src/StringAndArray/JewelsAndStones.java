package StringAndArray;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(solve(J, S));
    }

    public static int solve(String j, String s) {
        Set<Character> set = new HashSet<>();
        for (char jewel : j.toCharArray()) {
            set.add(jewel);
        }

        int count = 0;
        for (char stoneChar : s.toCharArray()) {
            System.out.println("stoneChat : " + stoneChar);
            if (set.contains(stoneChar)) {
                count++;
            }
        }
        return count;
    }
}
