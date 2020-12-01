package Graph_DfsAndBfs;

// Tree 구조의 객체에서 가장 깊은 Tree 의
// 깊이를 구하는 프로그램입니다.

// 트리의 구조는 자기 자신의 값과
// 양 옆에 하위 트리를 가질 수 있습니다.
class TreeNode {
    int value;
    TreeNode leftNode, rightNode;
    TreeNode(int x) {
        this.value = x;
    }
}

// 트리의 구조를 임의로 생성하고 해당 트리의
// 상단 트리에서 출발하여 가장 깊은 트리까지의
// 깊이를 출력합니다.
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.leftNode = new TreeNode(1);
        treeNode.rightNode = new TreeNode(4);
        treeNode.leftNode.leftNode = new TreeNode(5);
        treeNode.leftNode.rightNode = new TreeNode(8);
        treeNode.leftNode.leftNode.leftNode = new TreeNode(7);
        MaximumDepthOfBinaryTree object = new MaximumDepthOfBinaryTree();
        System.out.println(object.calcMaxDepth(treeNode));
    }

    // 매개변수로 받은 트리의 값이 null 일 경우
    // 0이라는 값을 리턴합니다.
    // 만약 값이 존재할 경우 다시 해당 트리의
    // 하위 트리를 조사하여 더 이상 하위 트리가
    // 존재하지 않는 최하단의 트리까지 내려갑니다.
    // 각 분기의 최하단부터 값을 리턴하며 오른쪽, 왼쪽
    // 분기 중 더 깊은 트리를 가진 값의 깊이를 리턴하며
    // 1씩 값을 추가합니다.
    // 맨 처음 최상단의 트리에서 호출한 좌우 트리의 깊이 값을
    // 얻게 되며 두 값을 비교하여 더 깊이 값이 큰 값에
    // 1을 더하고 해당 값을 리턴합니다.
    public int calcMaxDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftMax = calcMaxDepth(treeNode.leftNode);
        int rightMax = calcMaxDepth(treeNode.rightNode);
        return Math.max(leftMax, rightMax)+1;
    }
}
