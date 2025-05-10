package heap.medium;

public class ConstructStringWithRepeatLimit {
    int[] frequency = new int[26];

    public String repeatLimitedString(String s, int repeatLimit) {
        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        int pointer = 25;
        while (pointer >= 0) {
            if (frequency[pointer] == 0) {
                pointer--;
                continue;
            }
            char ch = (char) (pointer + 'a');
            int appendCount = Math.min(repeatLimit, frequency[pointer]);
            builder.repeat(ch, appendCount);
            frequency[pointer] -= appendCount;

            if (frequency[pointer] > 0) {
                int j = pointer - 1;
                while (j >= 0 && frequency[j] == 0) {
                    j--;
                }
                if (j < 0) {
                    break;
                }
                builder.append((char) (j + 'a'));
                frequency[j]--;
            }

        }
        return builder.toString();
    }
}

class ConstructStringWithRepeatLimitTest {
    public static void main(String[] args) {
        ConstructStringWithRepeatLimit constructStringWithRepeatLimit = new ConstructStringWithRepeatLimit();
        System.out.println(constructStringWithRepeatLimit.repeatLimitedString("aababab", 2));
    }
}
