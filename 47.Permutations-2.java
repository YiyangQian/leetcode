class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        boolean[] used = new boolean[nums.length];
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, cur, nums, used);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, boolean[] used) {
        if (cur.size() == nums.length) {
            res.add(new LinkedList<Integer>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (used[i] == false) {
                cur.add(nums[i]);
                used[i] = true;
                helper(res, cur, nums, used);
                cur.remove(cur.size() - 1);
                used[i] = false;
            }
        }
    }
}