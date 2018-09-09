class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) continue;
            int target = 0 - nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> cur = new LinkedList<Integer>();
                    cur.add(nums[i]);
                    cur.add(nums[l]);
                    cur.add(nums[r]);
                    res.add(cur);
                    while(l + 1 < nums.length && nums[l + 1] == nums[l]) l++;
                    while(r - 1 >= 0 && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;
                } else if (nums[l] + nums[r] < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}
