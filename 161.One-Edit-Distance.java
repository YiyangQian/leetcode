class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        int diff = l1 - l2;
        if (diff != -1 && diff != 1 && diff != 0) {
            return false;
        } else if (diff == 0) {
            return getCount(s, t) == 1;
        } else if (diff == -1) {
            return helper(s, t);
        } else {
            return helper(s, t);
        }
    }
    
    public int getCount(String s, String t) {
        int p = 0;
        int count = 0;
        while (p != s.length()) {
            if (s.charAt(p) != t.charAt(p)) {
                count++;
            }
            p++;
        }
        return count;
    }
    
    public boolean helper(String s, String t) {
        if (s.length() == 0 && t.length() == 1) return true;
        if (s.length() == 1 && t.length() == 0) return true;
        int p1 = 0, p2 = 0;
        int count = 0;
        while (p1 != s.length() && p2 != t.length()) {
            if (s.charAt(p1) != t.charAt(p2)) {
                if (count == 1) {
                    return false;
                } else {
                    count++;
                    if (s.length() > t.length()) {
                        p1++;
                    } else {
                        p2++;
                    }
                }
            } else {
                p1++;
                p2++;
            }
        }
        return true;
    }
}
