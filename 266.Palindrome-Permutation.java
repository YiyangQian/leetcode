class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            map.put(cur, (map.containsKey(cur)) ? map.get(cur) + 1 : 1);
        }
        boolean hasOdd = false;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                if (hasOdd)
                    return false;
                hasOdd = true;
            }
        }
        return true;
    }
}

// num request for palindrome
// if nothing in the middle everyone should be in pair
// if someone in the middle, one can be odd others must still be even

// one odd at most and others must be even
