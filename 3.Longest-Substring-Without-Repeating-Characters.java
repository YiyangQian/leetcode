class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0, track = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur) && map.get(cur) >= l) {
                l = map.get(cur) + 1;
            }
            map.put(cur, i);
            track = Math.max(track, i - l + 1);
        }
        return track;
    }
}