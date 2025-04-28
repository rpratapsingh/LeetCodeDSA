package binarytree.medium;

class NodeNew {
    public int val;
    public NodeNew left;
    public NodeNew right;
    public NodeNew parent;
}

public class LowestCommonAncestorIII {
    public NodeNew lowestCommonAncestor(NodeNew p, NodeNew q) {
        NodeNew middleNode = p;
        while (middleNode.parent != null){
            middleNode = middleNode.parent;
        }
        NodeNew root = middleNode;
        return lowestCommonAncestor(root,  p,  q);
    }

    public NodeNew lowestCommonAncestor(NodeNew root, NodeNew p, NodeNew q) {
        if (root == null)
            return null;
        if (p.val == root.val || q.val == root.val)
            return root;

        NodeNew leftFind = lowestCommonAncestor(root.left, p, q);
        NodeNew rightFind = lowestCommonAncestor(root.right, p, q);

        if (leftFind != null && rightFind != null) {
            return root;
        }

        if (leftFind != null)
            return leftFind;
        return rightFind;
    }
}
