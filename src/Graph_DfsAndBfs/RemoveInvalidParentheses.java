package Graph_DfsAndBfs;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String string = "(a)())()";
        RemoveInvalidParentheses object = new RemoveInvalidParentheses();
        System.out.println(object.removeInvalidParentheses(string));
    }

    private List<String> removeInvalidParentheses(String string) {
        List<String> result = new ArrayList<>();
        if (string == null) {
            return result;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(string);
        visited.add(string);
        boolean found = false;

        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (isValid(str)) {
                    result.add(str);
                    found = true;
                }
                if (found) {
                    continue;
                }
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) != '(' && str.charAt(j) != ')') {
                        continue;
                    }
                    String newStr = str.substring(0, j) + str.substring(j+1);
                    if (visited.contains(newStr) == false) {
                        queue.offer(newStr);
                        visited.add(newStr);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValid(String string) {
        int count = 0;
        for (char ch : string.toCharArray()) {
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
