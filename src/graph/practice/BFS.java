package graph.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static utils.AllUtils.to2DArray;

public class BFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> tracking = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        tracking.offer(0);
        visited[0] = true;
        while (!tracking.isEmpty()) {
            int n = tracking.poll();
            ArrayList<Integer> connections = adj.get(n);
            for (int connection : connections) {
                if (!visited[connection]) {
                    result.add(connection);
                    visited[connection] = true;
                    tracking.offer(connection);
                }
            }
        }
        return result;
    }
}

class GFG {
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

        BFS obj = new BFS();
        ArrayList<Integer> ans = obj.dfs(adj);
        for (int num : ans) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("~");
    }
}
