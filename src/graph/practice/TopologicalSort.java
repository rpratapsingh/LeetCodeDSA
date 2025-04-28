package graph.practice;

import graph.GraphUtils;

import java.util.*;

import static utils.AllUtils.to2DArray;

public class TopologicalSort {
    public List<Integer> topologicalSort(int V, int[][] edges) {
        Map<Integer, Set<Integer>> adj = GraphUtils.getAdjMatrixDirected(edges);
        boolean[] visited = new boolean[V];
        Stack<Integer> resultStack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (adj.getOrDefault(i, null) == null) {
                adj.put(i, new HashSet<>());
            }
            if (!visited[i]) {
                DFSSort(i, visited, adj, resultStack);
            }

        }
        List<Integer> result = new ArrayList<>();
        while (!resultStack.isEmpty()) {
            result.add(resultStack.pop());
        }
        return result;
    }

    public List<Integer> topologicalSort2(int V, int[][] edges) {
        Map<Integer, Set<Integer>> adj = GraphUtils.getAdjMatrixDirected(edges);
        int[] inDegree = new int[V];
        for (int u = 0; u < V; u++) {
            for (int v : adj.getOrDefault(u, new HashSet<>())) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int top = queue.poll();
            result.add(top);
            for (int n : adj.getOrDefault(top, new HashSet<>())) {
                inDegree[n]--;
                if (inDegree[n] == 0) {
                    queue.offer(n);
                }
            }
        }
        return result;
    }

    private void DFSSort(int u, boolean[] visited, Map<Integer, Set<Integer>> adj, Stack<Integer> result) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                DFSSort(v, visited, adj, result);
            }
        }
        result.push(u);
    }
}


class TopologicalSortTest {
    public static void main(String[] args) {
        int[][] edge = to2DArray(" [[1, 2], [1, 0]]");
        int v = 4;
        TopologicalSort sort = new TopologicalSort();
        List<Integer> result = sort.topologicalSort2(v, edge);
        for (int n : result) {
            System.out.println(n);
        }
    }

}
