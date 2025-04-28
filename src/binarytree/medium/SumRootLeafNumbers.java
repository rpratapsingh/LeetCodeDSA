package binarytree.medium;

public class SumRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return preOrder(root, 0);
    }

    private int preOrder(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int rightSum = preOrder(root.right, sum);
        int leftSum = preOrder(root.left, sum);
        return rightSum + leftSum;
    }
}

class SumRootLeafNumbersTest {
    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(4);
//
//        treeNode.left = new TreeNode(9);
//        treeNode.left.left = new TreeNode(5);
//        treeNode.left.right = new TreeNode(1);
//
//        treeNode.right = new TreeNode(0);

        TreeNode treeNode = new TreeNode(1);

        treeNode.left = new TreeNode(2);

        treeNode.right = new TreeNode(3);

        SumRootLeafNumbers sumRootLeafNumbers = new SumRootLeafNumbers();
        System.out.println(sumRootLeafNumbers.sumNumbers(treeNode));
    }
}
