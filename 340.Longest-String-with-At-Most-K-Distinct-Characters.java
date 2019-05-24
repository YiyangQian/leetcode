import java.util.*;

// Given a string, find the length of the longest substring T that contains at most k distinct characters.

// For example, Given s = “eceba” and k = 2,

// T is "ece" which its length is 3.

class Solution{

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int track = 0;
        int anchor = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            count.put(cur, count.getOrDefault(cur, 0) + 1);
            while (count.size() > k) {
                char toRemove = s.charAt(anchor++);
                int times = count.get(toRemove);
                count.put(toRemove, count.get(toRemove) - 1);
                if (count.get(toRemove) == 0) count.remove(toRemove);
            }
            track = Math.max(track, i - anchor + 1);
        }
        return track;
    }
}

