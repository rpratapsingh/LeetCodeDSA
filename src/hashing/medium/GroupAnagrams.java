// https://leetcode.com/problems/group-anagrams/description/

package hashing.medium;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> hashTable = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for (String str : strs) {
            char[] charSequence = str.toCharArray();
            Arrays.sort(charSequence);
            String orderedCharSequence = new String(charSequence);

            if (hashTable.containsKey(orderedCharSequence)) {
                hashTable.get(orderedCharSequence).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                hashTable.put(orderedCharSequence, newList);
            }
        }
        for (List<String> group : hashTable.values()) {
            result.add(group);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
