class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, cur, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                helper(res, cur, nums);
                cur.remove(cur.size() - 1);
            }
        }
    }
}