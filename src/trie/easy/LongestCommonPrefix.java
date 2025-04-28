package trie.easy;

import trie.Trie;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        for (String str : strs) {
            insert(root, str);
        }
        StringBuilder builder = new StringBuilder();
        while (!root.isWordEnd) {
            builder.append(root.ch);
            root = root.children[root.ch - 'a'];
        }
        return builder.toString();
    }

    private void insert(Trie root, String str) {
        Trie crawler = root;
        for (char ch : str.toCharArray()) {
            if (crawler.children[ch - 'a'] == null) {
                crawler.children[ch - 'a'] = new Trie();
                crawler.ch = ch;
            }
            crawler = crawler.children[ch - 'a'];
        }
        crawler.isWordEnd = true;
    }
}

class LongestCommonPrefixTest {
    public static void main(String[] args) {
        String[] input = {"ab", "a"};
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        System.out.println(commonPrefix.longestCommonPrefix(input));
    }
}
