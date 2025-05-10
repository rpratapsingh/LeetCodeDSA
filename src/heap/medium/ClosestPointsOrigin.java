package heap.medium;

import java.util.PriorityQueue;
import java.util.Queue;

public class ClosestPointsOrigin {

    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            int distance = (point[0] - 0) * (point[0] - 0) + (point[1] - 0) * (point[1] - 0);
            queue.offer(new int[]{distance, point[0], point[1]});
        }

        int i = 0;
        while (k > 0) {
            int[] top = queue.poll();
            result[i] = new int[]{top[1], top[2]};
            k--;
            i++;
        }
        return result;
    }
}

class ClosestPointsOriginTest {
    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 1;
        ClosestPointsOrigin closestPointsOrigin = new ClosestPointsOrigin();
        System.out.println(closestPointsOrigin.kClosest(points, k));
    }
}
