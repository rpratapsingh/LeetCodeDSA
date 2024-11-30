package datastructure;

public class BinarySearchTree<T extends Comparable<T>> {

    private int nodeCount = 0;
    private TreeNode root = null;

    private class TreeNode {
        T data;
        TreeNode left, right;

        public TreeNode(TreeNode left, TreeNode right, T elements) {
            this.data = elements;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return nodeCount;
    }

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        } else {
            root = add(root, element);
            nodeCount++;
            return true;
        }
    }

    private TreeNode add(TreeNode node, T element) {
        if (node == null) {
            node = new TreeNode(null, null, element);
        } else {
            if (element.compareTo(node.data) < 0) {
                node.left = add(node.left, element);
            } else {
                node.right = add(node.right, element);
            }
        }
        return node;
    }

    public boolean remove(T element) {
        if (contains(element)) {
            root = remove(root, element);
            nodeCount--;
            return true;
        }
        return false;
    }

    private TreeNode remove(TreeNode node, T element) {
        if (node == null) {
            return null;
        }
        int compare = element.compareTo(node.data);
        if (compare < 0) {
            node.left = remove(node.left, element);
        } else if (compare > 0) {
            node.right = remove(node.right, element);
        } else {
            if (node.left == null) {
                TreeNode rideChild = node.right;
                node.data = null;
                node = null;
                return rideChild;
            } else if (node.right == null) {
                TreeNode leftChild = node.left;
                node.data = null;
                node = null;
                return leftChild;
            } else {
                TreeNode temp = digLeft(node.right);
                node.data = temp.data;
                node.left = remove(node.right, temp.data);
            }
        }
        return node;
    }

    private TreeNode digLeft(TreeNode node) {
        TreeNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private TreeNode digRight(TreeNode node) {
        TreeNode current = node;
        while (current.right != null) {
            current = current.right;
        }
        return current;
    }

    public boolean contains(T element) {
        return contains(root, element);
    }

    private boolean contains(TreeNode node, T element) {
        if (node == null) {
            return false;
        }
        int compare = element.compareTo(node.data);

        if (compare < 0) {
            return contains(node.left, element);
        } else if (compare > 0) {
            return contains(node.right, element);
        } else {
            return true;
        }
    }

    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

}
