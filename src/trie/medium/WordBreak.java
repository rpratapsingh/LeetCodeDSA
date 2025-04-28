package trie.medium;

import trie.Trie;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    int length;
    Boolean[] t;

    public boolean wordBreak(String s, List<String> wordDict) {
        length = s.length();
        t = new Boolean[s.length()];
        return solve(0, s, wordDict);
    }

    private boolean solve(int index, String str, List<String> wordDict) {

        if (index == length) {
            return true;
        }

        if (t[index] != null) {
            System.out.println(index);
            return t[index];
        }

        for (int endIndex = index + 1; endIndex <= length; endIndex++) {
            String temp = str.substring(index, endIndex);
            if (wordDict.contains(temp) && solve(endIndex, str, wordDict)) {
                return t[index] = true;
            }
        }
        return t[index] = false;
    }
}

class WordBreakTest {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("go", "goal", "goals", "special");
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("goalspecial", input));
    }
}
