class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(candidates, target, cur, res, 0);
        return res;
    }
    
    public void helper(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new LinkedList(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                cur.add(candidates[i]);
                helper(candidates, target - candidates[i], cur, res, i);
                cur.remove(cur.size() - 1);                                                                              
            }
        }
    }
}