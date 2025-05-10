package graph.medium;

import java.util.*;

import static utils.AllUtils.to2DArray;

public class ShortestDistanceAfterRoadAdditionQueriesI {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < n - 1; i++) {
            Set<Integer> set = new HashSet<>();
            set.add(i + 1);
            adj.put(i, set);
        }

        int i = 0;
        for (int[] query : queries) {
            if (adj.containsKey(query[0])) {
                adj.get(query[0]).add(query[1]);
            } else {
                Set<Integer> set = new HashSet<>();
                set.add(query[1]);
                adj.put(query[0], set);
            }
            result[i++] = bsf(n, adj);
        }
        return result;
    }

    private int bsf(int n, Map<Integer, Set<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visited = new boolean[n];
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int top = queue.poll();
                if (top == n - 1) {
                    return level;
                }
                for (int ad : adj.get(top)) {
                    if (visited[ad])
                        continue;
                    queue.offer(ad);
                    visited[ad] = true;
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}

class ShortestDistanceAfterRoadAdditionQueriesITest {
    public static void main(String[] args) {
        int[][] queries = to2DArray("[[2,4],[0,2],[0,4]]");
        ShortestDistanceAfterRoadAdditionQueriesI path = new ShortestDistanceAfterRoadAdditionQueriesI();
        int[] results = path.shortestDistanceAfterQueries(5, queries);
        for (int result : results) {
            System.out.println(result);
        }
    }
}
