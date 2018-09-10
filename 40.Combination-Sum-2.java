class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(candidates, target, cur, set, 0);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (List<Integer> s : set) res.add(s);
        return res;
    }
    
    public void helper(int[] candidates, int target, List<Integer> cur, Set<List<Integer>> res, int start) {
        if (target == 0) {
            res.add(new LinkedList(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                cur.add(candidates[i]);
                helper(candidates, target - candidates[i], cur, res, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
