package binarytree.medium;

import java.util.*;

public class AllNodesDistance {


    Map<TreeNode, TreeNode> parentMapping = new HashMap<>();

    private void mapParent(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            parentMapping.put(root.left, root);
        mapParent(root.left);
        if (root.right != null)
            parentMapping.put(root.right, root);
        mapParent(root.right);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }

        Set<Integer> visited = new HashSet<>();
        mapParent(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target.val);
        while (!queue.isEmpty()) {
            if( k ==0)
                break;
            int size = queue.size();
            while (size > 0) {
                TreeNode front = queue.poll();
                if (front.left != null && !visited.contains(front.left.val)) {
                    queue.offer(front.left);
                    visited.add(front.left.val);
                }
                if (front.right != null && !visited.contains(front.right.val)) {
                    queue.offer(front.right);
                    visited.add(front.right.val);
                }
                TreeNode parent = parentMapping.get(front);
                if (parent != null && !visited.contains(parent.val)) {
                    queue.offer(parent);
                    visited.add(parent.val);
                }
                size--;
            }
            k--;
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()){
            result.add(queue.poll().val);
        }
        return result;
    }
}


class AllNodesDistanceTest {
    public static void main(String[] args) {
        TreeNode _3 = new TreeNode(3);
        TreeNode _5 = new TreeNode(5);
        TreeNode _1 = new TreeNode(1);
        _3.left = _5;
        _3.right = _1;

        TreeNode _6 = new TreeNode(6);
        TreeNode _2 = new TreeNode(2);
        _5.left = _6;
        _5.right = _2;

        TreeNode _0 = new TreeNode(0);
        TreeNode _8 = new TreeNode(8);
        _1.left = _0;
        _1.right = _8;

        TreeNode _7 = new TreeNode(7);
        TreeNode _4 = new TreeNode(4);
        _2.left = _7;
        _2.right = _4;

        AllNodesDistance allNodesDistance = new AllNodesDistance();
        for(int element : allNodesDistance.distanceK(_3, _5, 2)){
            System.out.println(element);
        }
    }
}
