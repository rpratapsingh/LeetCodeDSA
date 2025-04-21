// https://leetcode.com/problems/asteroid-collision/description/

package stack.medium;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean destroyed = false;
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                if (stack.peek() < -asteroid) {
                    stack.pop();
                    continue;
                } else if (stack.peek() == -asteroid) {
                    stack.pop();
                }
                destroyed = true;
                break;
            }
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

class AsteroidCollisionTest {
    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] asteroids1 = {8, -8};
        int[] asteroids2 = {10, 2, -5};
        int[] asteroids3 = {-2, -1, 1, 2};
        int[] asteroids4 = {-2, -2, -2,1};
        AsteroidCollision asteroidCollision = new AsteroidCollision();
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(asteroids)));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(asteroids1)));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(asteroids2)));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(asteroids3)));
        System.out.println(Arrays.toString(asteroidCollision.asteroidCollision(asteroids4)));
    }
}
