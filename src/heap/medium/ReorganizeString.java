// https://leetcode.com/problems/reorganize-string/description/?envType=problem-list-v2&envId=heap-priority-queue

package heap.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Tuple {
    char value;
    int frequency;

    public Tuple(char value, int frequency) {
        this.value = value;
        this.frequency = frequency;
    }
}

public class ReorganizeString {

    public String reorganizeString(String s) {
        PriorityQueue<Tuple> queue = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        // Map<Character, Integer> frequency = new HashMap<>();
        int[] frequency = new int[26];
        char[] chars = s.toCharArray();

        int limit = (s.length() + 1) / 2;
        for (char ch : chars) {
            frequency[ch - 'a']++;
            if (frequency[ch - 'a'] > limit) {
                return "";
            }
        }

        for (int i = 0; i < 26; i++) {
            if (frequency[i] > 0) {
                char temp = (char) (i + 'a');
                queue.offer(new Tuple(temp, frequency[i]));
            }
        }

        StringBuilder builder = new StringBuilder();
        while (queue.size() > 1) {
            Tuple first = queue.poll();
            Tuple second = queue.poll();
            builder.append(first.value);
            first.frequency--;
            builder.append(second.value);
            second.frequency--;
            if (first.frequency != 0) {
                queue.offer(first);
            }
            if (second.frequency != 0) {
                queue.offer(second);
            }
        }
        if (queue.size() != 0) {
            Tuple remaining = queue.poll();
            builder.append(remaining.value);
        }
        return builder.toString();
    }

    public String reorganizeString2(String s) {
        int size = s.length();
        int[] frequency = new int[26];
        char[] chars = s.toCharArray();
        char[] result = new char[size];

        int maxFrequency = 0;
        char maxFrequencyChar = 'a';
        int limit = (s.length() + 1) / 2;
        for (char ch : chars) {
            frequency[ch - 'a']++;
            if (frequency[ch - 'a'] > limit) {
                return "";
            }
            if (frequency[ch - 'a'] > maxFrequency) {
                maxFrequencyChar = ch;
                maxFrequency = frequency[ch - 'a'];
            }
        }

        int i=0;
        while(frequency[maxFrequencyChar - 'a']>0){
            result[i] = maxFrequencyChar;
            frequency[maxFrequencyChar - 'a']--;
            i+=2;
        }

        for (int j = 0; j < 26; j++) {
            if (frequency[j] > 0) {
                while (frequency[j] > 0) {
                    if (i >= size) {
                        i = 1;
                    }
                    result[i] = (char) (j + 'a');
                    frequency[j]--;
                    i+=2;
                }
            }
        }
        return new String(result);
    }


}

class ReorganizeStringTest {
    public static void main(String[] args) {
        ReorganizeString reorganizeString = new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString2("aaabbbccd"));
    }
}
