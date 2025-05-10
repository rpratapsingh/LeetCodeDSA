package binarytree.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteness {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean hasSeenNullNode = false;
        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front != null && hasSeenNullNode) {
                return false;
            }
            if (front == null) {
                hasSeenNullNode = true;
                //queue.offer(front);
                continue;
            } else {
                queue.offer(front.left);
                queue.offer(front.right);
            }
        }
        return true;
    }

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.right) + countNodes(root.left);
    }

    private boolean dfs(TreeNode root, int index, int totalNode) {
        if (root == null)
            return true;
        if (index > totalNode)
            return false;
        return dfs(root.left, 2 * index, totalNode) && dfs(root.right, 2 * index, totalNode);
    }

    public boolean isCompleteTreeDFS(TreeNode root) {
        int totalNodes = countNodes(root);
        int index = 0;
        return dfs(root, index, totalNodes);
    }
}

class CheckCompletenessTest {
    public static void main(String[] args) {
        int[] root = {1, 2, 3, 4, 5, 6};
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        _1.left = _2;
        _1.right = _3;

        TreeNode _4 = new TreeNode(4);
        TreeNode _5 = new TreeNode(5);
        _2.left = _4;
        _2.right = _5;

        TreeNode _6 = new TreeNode(6);
        _3.left = _6;

        CheckCompleteness checkCompleteness = new CheckCompleteness();
        System.out.println(checkCompleteness.isCompleteTree(_1));
    }
}
