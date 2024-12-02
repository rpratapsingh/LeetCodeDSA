// https://leetcode.com/problems/find-good-days-to-rob-the-bank/description/

package prefixsum.medium;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {

        List<Integer> results = new ArrayList<>();
        for (int index = time; index < security.length - time; index++) {
            int iteration = time;
            boolean notASolution = false;
            for (int j = time; j > 0; j--) {
                if (security[index - j] < security[index - j + 1]) {
                    notASolution = true;
                    break;
                }
            }
            if (notASolution)
                continue;
            notASolution = false;
            for (int j = 0; j < time; j++) {
                if (security[index + j] > security[index + j + 1]) {
                    notASolution = true;
                    break;

                }
            }
            if (notASolution)
                continue;
            results.add(index);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] security = {4,3,2,1};
        int time = 1;
        System.out.println(goodDaysToRobBank(security, time).toString());
    }
}
