package binarytree.medium;

public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (p.val == root.val || q.val == root.val)
            return root;

        TreeNode leftFind = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFind = lowestCommonAncestor(root.right, p, q);

        if (leftFind != null && rightFind != null) {
            return root;
        }

        if (leftFind != null)
            return leftFind;
        return rightFind;
    }
}
