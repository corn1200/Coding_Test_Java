package Graph_DfsAndBfs;

import java.util.Stack;

// 트리의 구조에서 가장 깊은 트리의
// 깊이를 구하는 문제를 dfs 방식으로 푼
// 프로그램입니다.
public class MaximumDepthOfBinaryTree_dfs {
    public static void main(String[] args) {
        MaximumDepthOfBinaryTree_dfs object = new MaximumDepthOfBinaryTree_dfs();
        TreeNode treeNode = new TreeNode(1);
        treeNode.leftNode = new TreeNode(2);
        treeNode.rightNode = new TreeNode(3);
        treeNode.leftNode.leftNode = new TreeNode(4);
        treeNode.leftNode.rightNode = new TreeNode(5);
        treeNode.leftNode.leftNode.leftNode = new TreeNode(6);

        System.out.println("val: " + object.calcMaxDepthAsDfs(treeNode));
    }

    // 스택에 최상단 트리를 넘겨줍니다.
    // 반복문이 반복될 때 마다 현재 트리의
    // 하단 트리를 넘겨주며 이전 트리는 제외시킵니다.
    //
    public int calcMaxDepthAsDfs(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> valueStacks = new Stack<>();
        stack.push(treeNode);
        valueStacks.push(1);
        int max = 0;

        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            int count = valueStacks.pop();
            max = Math.max(max, count);
            if (node.leftNode != null) {
                stack.push(node.leftNode);
                valueStacks.push(1 + count);
            }
            if (node.rightNode != null) {
                stack.push(node.rightNode);
                valueStacks.push(1 + count);
            }
        }

        return max;
    }
}
