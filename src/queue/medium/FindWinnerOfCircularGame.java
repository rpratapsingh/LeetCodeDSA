// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
package queue.medium;

public class FindWinnerOfCircularGame {
    public int findTheWinner(int n, int k) {
        int[] circularGame = new int[n];
        int notVisited = n, currentPosition = -1;

        while (notVisited != 1) {
            int round = k;
            while (round != 0) {
                currentPosition = (currentPosition + 1) % n;
                if (circularGame[currentPosition] != -1) {
                    round--;
                }
            }
            notVisited--;
            circularGame[currentPosition] = -1;
        }

        for (int i = 0; i < n; i++) {
            if (circularGame[i] != -1)
                return i+1;
        }
        return -1;
    }

//    public int findTheWinner(int n, int k) {
//        int res = 0;
//        for (int player_num = 2; player_num <= n; ++player_num) {
//            res = (res + k) % player_num;
//        }
//        return res + 1;
//    }
}

class FindWinnerOfCircularGameTest{
    public static void main(String[] args) {
        FindWinnerOfCircularGame find = new FindWinnerOfCircularGame();
        System.out.println(find.findTheWinner(6,5));
    }
}
