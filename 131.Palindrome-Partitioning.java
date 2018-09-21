class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new LinkedList<List<String>>();
        List<String> cur = new LinkedList<String>();
        helper(res, s, cur, 0);
        return res;
    }

    public void helper(List<List<String>> res, String s, List<String> cur, int start) {
        if (start == s.length()) {
            res.add(new LinkedList<String>(cur));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (isPalin(s.substring(start, i))) {
                cur.add(s.substring(start, i));
                helper(res, s, cur, i);
                cur.remove(cur.size() - 1);
            }
        }
        return;
    }

    public boolean isPalin(String s) {
        if (s.length() == 0)
            return false;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}