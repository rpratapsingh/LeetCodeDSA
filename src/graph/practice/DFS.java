package graph.practice;

import java.util.ArrayList;

import static utils.AllUtils.to2DArray;

public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfs(adj, visited, 0, result);
        return result;
    }

    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int node, ArrayList<Integer> result) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        result.add(node);
        //System.out.println(node);
        ArrayList<Integer> connections = adj.get(node);
        for (int connection: connections) {
            if (!visited[connection]) {
                dfs(adj, visited, connection, result);
            }
        }
    }
}


class DFSGFG {
    public static void main(String[] args) {
        int[][] graph = to2DArray(" [[2,3,1],[0],[0,4],[0],[2]]");
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int[] connections : graph) {
            ArrayList<Integer> nodes = new ArrayList<>();
            for (int node : connections) {
                nodes.add(node);
            }
            adj.add(nodes);
        }

        DFS obj = new DFS();
        ArrayList<Integer> ans = obj.dfs(adj);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("~");
    }
}
