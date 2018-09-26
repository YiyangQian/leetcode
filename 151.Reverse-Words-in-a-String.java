public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[words.length - 1 - i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
