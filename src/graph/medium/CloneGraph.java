package graph.medium;

import graph.practice.DFS;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    Map<String, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Set<Integer> visited = new HashSet<>();
        Node cloneNode = new Node(node.val, new ArrayList<>());
        map.clear();
        map.put(node.toString(), cloneNode);
        DFS(node, cloneNode);
        return cloneNode;
    }

    private void DFS(Node root, Node cloneNode) {
        for (Node node : root.neighbors) {
            if (!map.containsKey(node.toString())) {
                Node clone = new Node(node.val, new ArrayList<>());
                map.put(node.toString(), clone);
                cloneNode.neighbors.add(clone);
                DFS(node, clone);
            } else {
                cloneNode.neighbors.add(map.get(node.toString()));
            }
        }
    }
}

class CloneGraphTest {
    public static void main(String[] args) {

        Node _1 = new Node(1, new ArrayList<>());
        Node _2 = new Node(2, new ArrayList<>());
        Node _3 = new Node(3, new ArrayList<>());
        Node _4 = new Node(4, new ArrayList<>());

        _1.neighbors.add(_3);
        _3.neighbors.add(_1);

        _2.neighbors.add(_4);
        _4.neighbors.add(_2);

        CloneGraph cloneGraph = new CloneGraph();
        Node result = cloneGraph.cloneGraph(_1);
        System.out.println(result);
    }
}


//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(node.val);
//        while (!queue.isEmpty()) {
//            int top = queue.poll();
//            clone = new Node(node.val, new ArrayList<>());
//            visited.add(top);
//            for (Node neighbor : node.neighbors) {
//                if (visited.contains(neighbor.val)) {
//                    continue;
//                }
//                clone.neighbors.add(new Node(neighbor.val, new ArrayList<>()));
//                queue.offer(neighbor.val);
//            }
//        }
