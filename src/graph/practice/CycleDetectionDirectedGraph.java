package graph.practice;

import graph.GraphUtils;

import java.util.*;

import static utils.AllUtils.to2DArray;

public class CycleDetectionDirectedGraph {
    public boolean isCycle(int V, int[][] edges) {
        Map<Integer, Set<Integer>> adj = GraphUtils.getAdjMatrixDirected(edges);

        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];
        for (int i = 0; i < V; i++) {
            int size = adj.getOrDefault(i, new HashSet<>()).size();
            if (size > 0) {
                if (!visited[i] && isCycleDFS(i, visited, adj, inRecursion)) {
                    return true;
                }
            }
        }
        return false;
    }

//    private boolean isCycleBFS(int u, boolean[] visited, Map<Integer, Set<Integer>> adj) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(u);
//        visited[u] = true;
//        while (!queue.isEmpty()) {
//            int top = queue.poll();
//            for (int connection : adj.get(top)) {
//                if (visited[connection]) {
//                    return true;
//                }
//                queue.offer(connection);
//                visited[connection] = true;
//            }
//        }
//        return false;
//    }

    private boolean isCycleDFS(int u, boolean[] visited, Map<Integer, Set<Integer>> adj, boolean[] inRecursion) {
        visited[u] = true;
        inRecursion[u] = true;
        for (int connection : adj.get(u)) {
            if (visited[connection] == false && isCycleDFS(connection, visited, adj, inRecursion)) {
                return true;
            }
            else if(inRecursion[connection]){
                return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}

class CycleDetectionDirectedGraphTest {
    public static void main(String[] args) {
        int[][] edges = to2DArray(" [[0, 1], [0, 3], [1, 3]");
        int V = 4;
        CycleDetectionDirectedGraph obj = new CycleDetectionDirectedGraph();
        boolean ans = obj.isCycle(V, edges);
        System.out.println(ans ? "true" : "false");
        System.out.println("~");
    }
}
