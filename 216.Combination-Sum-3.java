class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> cur = new LinkedList<>();
        helper(res, cur, k, n, 1);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int k, int target, int start) {
        if (target == 0 && cur.size() == k) {
            res.add(new LinkedList<Integer>(cur));
        }
        if (start > 9 || cur.size() > k || target < 0) return;
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            helper(res, cur, k, target - i, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
