package Graph_DfsAndBfs;

import java.util.*;

// 일련의 문장이 프로그래밍 문법을 지키고 있는지 확인하고
// 문법을 지키지 않는 문장을 수정하여 유효한 프로그래밍
// 문장으로 변환 후 저장합니다. 모든 변환 경우를 저장 후
// 저장한 값을 출력합니다.
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String string = "(a)())()";
        RemoveInvalidParentheses object = new RemoveInvalidParentheses();
        System.out.println(object.removeInvalidParentheses(string));
    }

    // 매개변수로 유효한 문법인지 확인할 문장을 받습니다.
    // 문장이 유효할 경우 반환할 List 구조에 저장합니다.
    // 유효하지 않을 경우 Queue 구조에 추가하고 Set 구조에
    // 추가하여 괄호를 하나씩 제거하면서 유효한 문장을 만듭니다.
    // 괄호를 하나씩 제거하며 수정된 문장을 Queue 에 추가하며
    // 다시 유효한 문법인지를 확인하고 유효할시 List 에 저장합니다.
    // 유효와 별개로 중복으로 수정된 문장인가를 판별하는 Set 에는
    // 매번 저장합니다.
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

    // 문장이 프로그래밍 문법을 지키는지 확인합니다.
    // 좌측 괄호보다 우측 괄호가 먼저 나오거나
    // 괄호의 쌍이 맞지 않으면 유효하지 않음을
    // 반환합니다.
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
