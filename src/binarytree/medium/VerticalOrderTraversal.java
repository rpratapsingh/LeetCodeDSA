package binarytree.medium;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    int value;
    int depth;

    public Node(int value, int depth) {
        this.value = value;
        this.depth = depth;
    }
}

public class VerticalOrderTraversal {

    Map<Integer, List<Node>> store = new TreeMap<>();
    public void print(TreeNode root, int position, int depth) {
        if (root == null) {
            return;
        }
        if (store.containsKey(position)) {
            store.get(position).add(new Node(root.val, depth));
        } else {
            List<Node> temp = new ArrayList<>();
            temp.add(new Node(root.val, depth));
            store.put(position, temp);
        }
        print(root.left, position - 1, depth + 1);
        print(root.right, position + 1, depth + 1);
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        print(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();

        for (List<Node> node : store.values()) {
            node.sort(new Comparator() {
                @Override
                public int compare(Object o1, Object o2) {
                    return ((Node) (o1)).depth - ((Node) (o2)).depth;
                }
            });
            List<Integer> innerList = new ArrayList<>();
            for (Node items : node) {
                innerList.add(items.value);
            }
            result.add(innerList);
        }
        return result;
    }
}


class VerticalOrderTraversalTest {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);

        VerticalOrderTraversal verticalOrderTraversal = new VerticalOrderTraversal();
        List<List<Integer>> result = verticalOrderTraversal.verticalOrder(treeNode);
        for (List<Integer> list : result) {
            System.out.print("[");
            for (int value : list) {
                System.out.print(value + " ");
            }
            System.out.print("]");
        }
    }

    public static void print(TreeNode root) {
        if (root == null) {
            return;
        }
        print(root.left);
        print(root.right);
        System.out.println(root.val);
    }
}
