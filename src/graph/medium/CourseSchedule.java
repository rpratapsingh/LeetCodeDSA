package graph.medium;

import java.util.*;

import static utils.AllUtils.to2DArray;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjMatrix = adjMatrix(prerequisites);
        int[] inDegree = new int[numCourses];
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if(adjMatrix.get(i)!=null) {
                for (int j : adjMatrix.get(i)) {
                    inDegree[j]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            count++;
            if(adjMatrix.get(top)!=null) {
                for (int j : adjMatrix.get(top)) {
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        queue.offer(j);
                    }
                }
            }
        }

        return count == numCourses;
    }

    private Map<Integer, Set<Integer>> adjMatrix(int[][] prerequisites) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for (int[] connection : prerequisites) {
            Set<Integer> entry = adj.get(connection[1]);
            if(entry == null){
                entry =  new HashSet<>();
            }
            entry.add(connection[0]);
            adj.put(connection[1], entry);
        }
        return adj;
    }
}


class CourseScheduleTest {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = to2DArray("[[0,1]]");
        CourseSchedule courseSchedule = new CourseSchedule();
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
    }
}
