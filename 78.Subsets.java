class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        Arrays.sort(nums);
        helper(res, cur, nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        if (start > nums.length) return;
        res.add(new LinkedList<Integer>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}