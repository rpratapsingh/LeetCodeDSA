package graph.medium;

import graph.GraphUtils;

import java.util.*;

import static utils.AllUtils.to2DArray;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] connection : prerequisites) {
            Set<Integer> entry = adj.get(connection[1]);
            if (entry == null) {
                entry = new HashSet<>();
            }
            entry.add(connection[0]);
            adj.put(connection[1], entry);
            inDegree[connection[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            result[index++] = top;
            Set<Integer> connections = adj.get(top);
            if (connections != null) {
                for (int connection : connections) {
                    inDegree[connection]--;
                    if (inDegree[connection] == 0) {
                        queue.offer(connection);
                    }
                }
            }
        }
        return numCourses == index ? result : new int[]{};
    }
}

class CourseScheduleIITest {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = to2DArray("[[1,0]]");
        CourseScheduleII courseScheduleII = new CourseScheduleII();
        int[] result = courseScheduleII.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(result));
    }
}
