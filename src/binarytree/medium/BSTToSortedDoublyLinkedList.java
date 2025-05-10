package binarytree.medium;


// left back, right front
public class BSTToSortedDoublyLinkedList {
    TreeNode front;
    TreeNode back;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null)
            return null;
        inOrder(root);
        back.right = front;
        front.left = back;
        return front;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);

        if (back != null) {
            back.right = root;
            root.left = back;
        } else {
            front = root;
        }
        back = root;
        inOrder(root.right);
    }
}


class BSTToSortedDoublyLinkedListTest {
    public static void main(String[] args) {
        TreeNode _4 = new TreeNode(4);
        TreeNode _2 = new TreeNode(2);
        TreeNode _5 = new TreeNode(5);
        _4.left = _2;
        _4.right = _5;

        TreeNode _1 = new TreeNode(1);
        TreeNode _3 = new TreeNode(3);
        _2.left = _1;
        _2.right = _3;

        BSTToSortedDoublyLinkedList linkedList = new BSTToSortedDoublyLinkedList();
        linkedList.treeToDoublyList(_4);
    }
}
