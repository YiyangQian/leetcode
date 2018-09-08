class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int l = 0, r = s.length() - 1;
        while (l < s.length() && r > 0 && l < r) {
            if (!set.contains(s.charAt(l))) {
                l++;
                continue;
            }
            if (!set.contains(s.charAt(r))) {
                r--;
                continue;
            }
            s = swapTwoChar(s, l, r);
            l++;
            r--;
        }
        return s;
    }
    
    public String swapTwoChar(String s, int l, int r) {
        StringBuilder sb = new StringBuilder(s);
        char tempt = s.charAt(l);
        sb.setCharAt(l, s.charAt(r));
        sb.setCharAt(r, tempt);
        return sb.toString();
    }
}