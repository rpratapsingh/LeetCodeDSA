package binarytree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {
    List<Integer> result = new ArrayList<>();
    Stack<Integer> right = new Stack<>();

    private boolean isLeaf(TreeNode node) {
        return node.right == null && node.left == null;
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        if (!isLeaf(root))
            result.add(root.val);

        TreeNode temp = root.left;
        while (temp != null) {
            if (!isLeaf(temp))
                result.add(temp.val);
            if (temp.left != null)
                temp = temp.left;
            else
                temp = temp.right;
        }

        traverse(root);

        temp = root.right;
        while (temp != null) {
            if (!isLeaf(temp))
                right.add(temp.val);
            if (temp.right != null)
                temp = temp.right;
            else
                temp = temp.left;
        }
        while (!right.isEmpty())
            result.add(right.pop());
        return result;
    }

    private TreeNode traverse(TreeNode root) {
        if (root == null)
            return null;
        TreeNode leftChild = traverse(root.left);
        TreeNode rightChild = traverse(root.right);
        if (leftChild == null && rightChild == null) {
            //System.out.println(root.val);
            result.add(root.val);
        }
        return root;
    }
}

class BoundaryOfBinaryTreeTest {
    public static void main(String[] args) {
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

        TreeNode _7 = new TreeNode(7);
        TreeNode _8 = new TreeNode(8);
        _5.left = _7;
        _5.right = _8;

        TreeNode _9 = new TreeNode(9);
        TreeNode _10 = new TreeNode(10);
        _6.left = _9;
        _6.right = _10;

        BoundaryOfBinaryTree boundaryOfBinaryTree = new BoundaryOfBinaryTree();
        List<Integer> result = boundaryOfBinaryTree.boundaryOfBinaryTree(_1);
        for (int element : result) {
            System.out.print(element + " ");
        }
    }
}
