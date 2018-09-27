class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        if (start < str.length) {
            reverse(str, start, str.length - 1);
        }
    }
    
    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tempt = s[l];
            s[l] = s[r];
            s[r] = tempt;
            l++;
            r--;
        }
    }
}
