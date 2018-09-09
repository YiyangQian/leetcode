class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if (digits.length() == 0) return res;
        Map<Character, String> dict = new HashMap<Character, String>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");
        Queue<String> q = new LinkedList<String>();        
        q.add("");
        int curLen = 0;
        while (curLen < digits.length()) {
            curLen = q.peek().length();
            if (curLen == digits.length()) break;            
            String polled = q.poll();
            String curMapped = dict.get(digits.charAt(curLen));
            for (int i = 0; i < curMapped.length(); i++) {
                q.add(polled + curMapped.charAt(i));
            }
        }
        while (!q.isEmpty()) {
            res.add(q.poll());
        }
        return res;
    }
}