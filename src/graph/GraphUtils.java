package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GraphUtils {
    public static Map<Integer, Set<Integer>> getAdjMatrixUndirected(int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            Set<Integer> entryU = adj.getOrDefault(u, null);
            if (entryU == null) {
                entryU = new HashSet<>();
            }
            entryU.add(v);
            adj.put(u, entryU);

            Set<Integer> entryV = adj.getOrDefault(v, null);
            if (entryV == null) {
                entryV = new HashSet<>();
            }
            entryV.add(u);
            adj.put(v, entryV);
        }
        return adj;
    }

    public static Map<Integer, Set<Integer>> getAdjMatrixDirected(int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            Set<Integer> entry = adj.getOrDefault(u, null);
            if (entry == null) {
                entry = new HashSet<>();
            }
            entry.add(v);
            adj.put(u, entry);
            if (!adj.containsKey(v)) {
                adj.put(v, new HashSet<>());
            }
        }
        return adj;
    }
}
