class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        helper(0, 0, "", n, res);
        return res;
    }
    
    public void helper(int left, int right, String cur, int max, List<String> res) {
        if (left == max && right == max) {
            res.add(cur);
            return;
        }
        if (left <= max) helper(left + 1, right, cur + "(", max, res);
        if (left > right) helper(left, right + 1, cur + ")", max, res);
    }
}