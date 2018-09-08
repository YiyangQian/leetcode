class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < strs.length; i++) {
            char curPattern = pattern.charAt(i);
            if (map.containsKey(curPattern)) {
                if(!map.get(curPattern).equals(strs[i])) return false;
            } else if (map.containsValue(strs[i])) {
                return false;
            }else {
                map.put(curPattern, strs[i]);
            }
        }
        return true;
    }
}