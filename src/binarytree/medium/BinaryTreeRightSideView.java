package binarytree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    List<Integer> result = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            TreeNode node = null;
            while (n > 0) {
                node = queue.peek();
                queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                n--;
            }
            result.add(node.val);
        }
        return result;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        preOrder(root, 1);
        return result;
    }

    private void preOrder(TreeNode root, int level) {
        if (root == null)
            return;
        if (level > result.size()) {
            result.add(root.val);
        }
        preOrder(root.right, level + 1);
        preOrder(root.left, level + 1);
    }
}

class BinaryTreeRightSideViewTest {
    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1);
//
//        treeNode.left = new TreeNode(2);
//        treeNode.left.right = new TreeNode(5);
//
//        treeNode.right = new TreeNode(3);
//        treeNode.right.right = new TreeNode(4);


        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(5);

        treeNode.right = new TreeNode(3);

        BinaryTreeRightSideView binaryTreeRightSideView = new BinaryTreeRightSideView();
        List<Integer> result = binaryTreeRightSideView.rightSideView2(treeNode);
        for (int number : result) {
            System.out.println(number);
        }
    }
}
