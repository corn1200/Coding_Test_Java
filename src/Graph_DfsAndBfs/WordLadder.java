package Graph_DfsAndBfs;

import java.util.*;

// 시작 단어와 끝 단어 사이에 한 글자씩만 치환하며
// 시작 단어에서 끝 단어까지 완성하려면
// 지정된 단어들을 사다리처럼 이어야합니다.
// 최소한의 단어로 시작 단어에서 끝 단어까지 잇는데
// 몇개의 단어가 사용되는지 출력하는 프로그램입니다.
public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot", "dot", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        WordLadder object = new WordLadder();
        System.out.println(object.ladderLength_neighbor("hit", "cog", wordList));
    }

    // 시작 단어와 끝 단어, 단어 목록을 매개변수로 받습니다.
    // 단어 목록이 비어있거나 단어 목록 중에 끝 단어에 해당하는
    // 단어가 없다면 시작 단어에서 끝 단어까지 연결할 수 없기
    // 때문에 0을 반환하며 종료합니다.
    private int ladderLength_neighbor(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.contains(endWord) == false) {
            return 0;
        }
        // 큐 구조에 시작 단어를 삽입하고 큐의 단어를 하나씩
        // 꺼내며 만약 끝 단어에 해당하는 단어가 꺼내지면
        // 현재까지의 길이를 반환합니다.
        // 큐에서 꺼낸 단어가 끝 단어가 아니라면 다음
        // 작업을 진행합니다.
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);
        queue.offer(beginWord);
        dict.remove(beginWord);
        int level = 1;

        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                // 큐에 저장된 단어를 꺼냈을 때 끝 단어일 경우
                // 단어 사다리의 길이를 반환합니다.
                if (str.equals(endWord)) {
                    return level;
                }
                // 만약 큐에서 꺼내온 단어가 끝 단어가 아니라면
                // 꺼내온 단어에서 한 글자씩 치환하여 단어 목록 중에
                // 있는 단어를 List 로 반환받고 큐에 저장합니다.
                for (String neighbor : neighbors(str, dict)) {
                    queue.offer(neighbor);
                }
            }
            level++;
        }
        return 0;
    }

    // 매개변수로 현재 단어와 단어 목록을 받습니다.
    // 현재 단어의 각 글자를 하나씩 치환하며 단어 목록 중에
    // 있는 단어를 단어 목록에서 삭제하고 List 에 담아서
    // List 를 반환합니다.
    List<String> neighbors(String s, Set<String> dict) {
        List<String> res = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char[] chars = s.toCharArray();
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String word = new String(chars);
                if (dict.remove(word)) {
                    res.add(word);
                }
            }
        }
        return res;
    }
}
