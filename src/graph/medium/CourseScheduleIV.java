package graph.medium;

import java.util.*;

import static utils.AllUtils.to2DArray;

public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        List<Boolean> results = new ArrayList<>();

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] pre : prerequisites) {
            List<Integer> list = adj.getOrDefault(pre[0], new ArrayList<>());
            list.add(pre[1]);
            adj.put(pre[0], list);
            inDegree[pre[1]]++;
        }

        int index = 1;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            if (adj.get(top) == null)
                continue;
            for (int ad : adj.get(top)) {
                inDegree[ad]--;
                if (inDegree[ad] == 0) {
                    queue.offer(ad);
                    System.out.println(ad);
                }
                Set<Integer> set = indexMap.getOrDefault(ad, new HashSet<>());
                set.add(top);
                set.addAll(indexMap.getOrDefault(top, new HashSet<>()));
                indexMap.put(ad, set);
            }
        }

        for (int[] q : queries) {
            int u = q[0];
            int v = q[1];
            if (!indexMap.containsKey(v)) {
                results.add(false);
            } else {
                if (indexMap.get(v).contains(u)) {
                    results.add(true);
                } else {
                    results.add(false);
                }
            }

        }
        return results;
    }
}

class CourseScheduleIVTest {
    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = to2DArray("[[0,1],[1,2],[2,4],[3,2],[5,3]]");
        int[][] queries = to2DArray("[[0,3],[1,4],[1,3],[2,3],[3,2],[5,4]]");
        CourseScheduleIV courseScheduleIV = new CourseScheduleIV();
        List<Boolean> results = courseScheduleIV.checkIfPrerequisite(numCourses, prerequisites, queries);
        for (boolean result : results) {
            System.out.println(result);
        }
    }
}
