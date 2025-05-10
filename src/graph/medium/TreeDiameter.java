package graph.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.AllUtils.to2DArray;

public class TreeDiameter {
    int max = Integer.MIN_VALUE;
    int farthestNode = -1;

    public int treeDiameter(int[][] edges) {
        if (edges.length == 0)
            return 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (adj.containsKey(u)) {
                adj.get(u).add(v);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(v);
                adj.put(u, list);
            }
            if (adj.containsKey(v)) {
                adj.get(v).add(u);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(u);
                adj.put(v, list);
            }
        }
        int[] visited = new int[edges.length + 1];
        dfs(0, adj, 0, visited);

        max = Integer.MIN_VALUE;
        visited = new int[edges.length + 1];
        dfs(farthestNode, adj, 0, visited);
        return max;
    }

    private void dfs(int node, Map<Integer, List<Integer>> adj, int length, int[] visited) {
        //System.out.println(length);
        if (visited[node] == 1)
            return;
        visited[node] = 1;
        if (length > max) {
            max = length;
            farthestNode = node;
        }
        for (int edge : adj.get(node)) {
            dfs(edge, adj, length + 1, visited);
        }
    }
}

class TreeDiameterTest {
    public static void main(String[] args) {
        int[][] edges = to2DArray("[[0,1],[0,2]]");
        TreeDiameter treeDiameter = new TreeDiameter();
        System.out.println(treeDiameter.treeDiameter(edges) + " result ");
    }
}
