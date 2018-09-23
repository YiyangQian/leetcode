class Solution {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>(); 
        return helper(pattern, str, 0, 0, map);
    }
    
    public boolean helper(String pattern, String str, int startPattern, int startStr, Map<Character, String> map) {
        if (startPattern == pattern.length() && startStr == str.length())
            return true;
        if (startPattern == pattern.length() && startStr != str.length())
            return false;
        if (startStr == str.length() && startPattern != pattern.length())
            return false;
        boolean res = false;
        char curPattern = pattern.charAt(startPattern);
        if (map.containsKey(curPattern)) {
            String mapped = map.get(curPattern);
            if (startStr + mapped.length() <= str.length() && str.substring(startStr, startStr + mapped.length()).equals(mapped)) {
                return helper(pattern, str, startPattern + 1, startStr + mapped.length(), map);
            } else {
                return false;
            }
        } else {
            for (int i = startStr + 1; i <= str.length(); i++) {
                Map<Character, String> copied = new HashMap<Character, String>(map);
                if (!copied.containsValue(str.substring(startStr, i))) {
                    copied.put(curPattern, str.substring(startStr, i));
                    res = res || helper(pattern, str, startPattern + 1, i, copied); 
                }
            }
        }
        return res;
    }
    
}