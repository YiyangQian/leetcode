class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<Integer> deadEnd = new HashSet<Integer>();
        return helper(s, wordDict, 0, deadEnd);
    }

    public boolean helper(String s, List<String> wordDict, int start, Set<Integer> deadEnd) {
        if (deadEnd.contains(start))
            return false;
        if (start == s.length())
            return true;
        boolean res = false;
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                if (helper(s, wordDict, i, deadEnd)) {
                    res = true;
                } else {
                    deadEnd.add(i);
                }
            }
        }
        return res;
    }
}