package StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMapping {
    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};
        int[] result = anagramMappings(A, B);
        print(result);
    }

    public static int[] anagramMappings(int[] a, int[] b) {
        int[] result = new int[a.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(b[i], i);
        }

        for (int i = 0; i < a.length; i++) {
            result[i] = map.get(a[i]);
        }
        return result;
    }

    public static void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
