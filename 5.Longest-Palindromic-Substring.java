class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            int oddSteps = getSteps(s, i);
            int evenSteps = getEvenSteps(s, i);
            if (oddSteps * 2 - 1 > res.length()) res = s.substring(i - oddSteps + 1, i + oddSteps);
            if (evenSteps * 2 > res.length()) res = s.substring(i - evenSteps + 1, i + evenSteps + 1);
        }
        return res;
    }
    
    public int getSteps(String s, int i) {
        int step = 1;
        while (i - step >= 0 && i + step < s.length() && s.charAt(i - step) == s.charAt(i + step)) step++;
        return step;
    }

    public int getEvenSteps(String s, int i) {
        int step = 0; 
        while (i - step >= 0 && i + step + 1 < s.length() &&  s.charAt(i - step) == s.charAt(i + step + 1)) step++;
        return step;
    }
}