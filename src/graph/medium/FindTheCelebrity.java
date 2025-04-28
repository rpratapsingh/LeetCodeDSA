package graph.medium;

import java.util.ArrayList;
import java.util.List;

import static utils.AllUtils.to2DArray;

class Relation {
    boolean knows(int a, int b) {
        //int[][] graph = to2DArray("[[1,1,0],[0,1,0],[1,1,1]]");
        int[][] graph = to2DArray("[[1,1],[1,1]]");
        return graph[a][b] == 1;
    }
}

public class FindTheCelebrity extends Relation {
    public int findCelebrity(int n) {
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                if (knows(i, j)) {
                    inDegree[j]++;
                }
            }
        }

        List<Integer> possibleCandidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1) {
                possibleCandidates.add(i);
            }
        }

        int result = -1;
        for (int candidate : possibleCandidates) {
            int i = 0;
            for (; i < n; i++) {
                if (candidate == i)
                    continue;
                if (knows(candidate, i)) {
                    break;
                }
            }
            if (i == n) {
                result = candidate;
            }
        }
        return result;
    }

    public int findCelebrity2(int n) {
        boolean[] canNotBeCelebrity = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(i, j)) {
                    canNotBeCelebrity[i] = true;
                } else {
                    canNotBeCelebrity[j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!canNotBeCelebrity[i]) {
                return i;
            }
        }
        return -1;
    }

    public int findCelebrity3(int n) {
        int possibleCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (possibleCandidate == i) {
                continue;
            }
            if (knows(possibleCandidate, i)) {
                possibleCandidate = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (i == possibleCandidate)
                continue;
            if (knows(possibleCandidate, i) || !knows(i, possibleCandidate)) {
                return -1;
            }
        }
        return possibleCandidate;
    }
}


class FindTheCelebrityTest {
    public static void main(String[] args) {
        FindTheCelebrity findTheCelebrity = new FindTheCelebrity();
        System.out.println(findTheCelebrity.findCelebrity3(2));
    }
}
