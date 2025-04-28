package graph.practice;

import graph.GraphUtils;

import java.util.*;

public class CycleDetectionUndirectedGraph {
    public boolean isCycle(int V, int[][] edges) {
        Map<Integer, Set<Integer>> adj = GraphUtils.getAdjMatrixUndirected(edges);

        // Code here
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (adj.get(i) == null)
                continue;
            if (!visited[i] && isCyclePresent(i, adj, visited, -1))
                return true;
        }
        return false;
    }

    private boolean isCyclePresent(int u, Map<Integer, Set<Integer>> adj, boolean[] visited, int parent) {
        visited[u] = true;
        for (int n : adj.get(u)) {
            if (n == parent)
                continue;
            if (visited[n])
                return true;
            if (isCyclePresent(n, adj, visited, u))
                return true;
        }
        return false;
    }

    public boolean isCycleBFS(int V, int[][] edges) {
        Map<Integer, Set<Integer>> adj = GraphUtils.getAdjMatrixUndirected(edges);
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && isCyclePresentBFS(i, visited, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCyclePresentBFS(int i, boolean[] visited, Map<Integer, Set<Integer>> adj) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, -1});
        visited[i] = true;

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            System.out.println(Arrays.toString(top));
            Set<Integer> connections = adj.get(top[0]);
            for (int connection : connections) {
                if (connection == top[1])
                    continue;
                if (visited[connection])
                    return true;
                visited[connection] = true;
                queue.offer(new int[]{connection, top[0]});
            }
        }
        return false;
    }
}

class CycleDetectionUndirectedGraphTest {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}};
        int V = 2;
        CycleDetectionUndirectedGraph obj = new CycleDetectionUndirectedGraph();
        boolean ans = obj.isCycleBFS(V, edges);
        System.out.println(ans ? "true" : "false");
        System.out.println("~");
    }
}

