class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, cur, nums, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        if (cur.size() <= nums.length)
            res.add(new LinkedList<Integer>(cur));
        for (int i = start; i < nums.length; i++) {
            //the one at start position can join, but others after him must not be duplicated
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            helper(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
        return;
    }
}

// []
// 1  2 
// 2  2 
// 2
