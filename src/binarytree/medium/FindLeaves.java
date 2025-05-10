package binarytree.medium;

import java.util.*;

public class FindLeaves {
    Map<Integer, List<Integer>> result = new HashMap<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        dfs(root);
        return new ArrayList<>(result.values());
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        int height = 1 + Math.max(leftHeight, rightHeight);
        List<Integer> temp = result.getOrDefault(height, new ArrayList<>());
        temp.add(root.val);
        result.put(height, temp);
        return height;
    }
}

class FindLeavesTest {
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

//        TreeNode _1 = new TreeNode(1);
//        TreeNode _2 = new TreeNode(2);
//        TreeNode _3 = new TreeNode(3);
//        _2.left = _3;
//        _3.left = _1;

        FindLeaves findLeaves = new FindLeaves();
        List<List<Integer>> result = findLeaves.findLeaves(_2);

        for (List<Integer> elements : result) {
            for (int element : elements) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

    }
}
