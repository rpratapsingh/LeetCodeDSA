package arrays.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] wordsTwoFrequency = new int[26];
        for (String word : words2) {
            int[] localFrequency = new int[26];
            for (char letter : word.toCharArray()) {
                localFrequency[letter - 'a']++;
                wordsTwoFrequency[letter - 'a'] = Math.max(wordsTwoFrequency[letter - 'a'], localFrequency[letter - 'a']);
            }
        }

        for (String word : words1) {
            int[] frequency = new int[26];
            for (char letter : word.toCharArray()) {
                frequency[letter - 'a']++;
            }
            if (isSubset(frequency, wordsTwoFrequency)) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean isSubset(int[] frequency, int[] wordsTwoFrequency) {
        for (int i = 0; i < 26; i++) {
            if (wordsTwoFrequency[i] == 0)
                continue;
            if (wordsTwoFrequency[i] > frequency[i]) {
                return false;
            }
        }
        return true;
    }
}

class WordSubsetsTest {
    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"}, words2 = {"lo", "eo"};
        WordSubsets wordSubsets = new WordSubsets();
        for (String str : wordSubsets.wordSubsets(words1, words2)) {
            System.out.println(str);
        }
    }
}
