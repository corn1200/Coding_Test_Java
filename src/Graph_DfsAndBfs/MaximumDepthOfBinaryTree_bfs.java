package Graph_DfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

// 트리 구조에서 가장 깊은 트리의 깊이를
// 구하는 프로그램입니다.
public class MaximumDepthOfBinaryTree_bfs {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.leftNode = new TreeNode(1);
        treeNode.rightNode = new TreeNode(4);
        treeNode.leftNode.leftNode = new TreeNode(5);
        treeNode.leftNode.rightNode = new TreeNode(8);
        treeNode.leftNode.leftNode.leftNode = new TreeNode(7);
        MaximumDepthOfBinaryTree_bfs object = new MaximumDepthOfBinaryTree_bfs();
        System.out.println(object.calcMaxDepthAsBfs(treeNode));
    }

    // 최상단 트리를 매개변수로 넘겨주고
    // queue 구조를 활용하여 트리를 개별로 보는
    // 대신 하나의 층으로 보고 계산합니다.
    // 최상단 트리부터 시작하여 매 층에 있는
    // 트리를 확인하고 큐에 담습니다.
    // 다시 큐에서 제거하는 동시에
    // 하위 트리가 있는지 확인하고 있다면 새 층에 진입하여
    // 같은 작업을 반복합니다.
    // 층을 내려갈 수록 깊이를 1씩 늘립니다.
    private int calcMaxDepthAsBfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);
        int count = 0;
        while (queue.isEmpty() == false) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.leftNode != null) {
                    queue.offer(node.leftNode);
                }
                if (node.rightNode != null) {
                    queue.offer(node.rightNode);
                }
            }
            count++;
        }
        return count;
    }
}
