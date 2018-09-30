class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));        
    }
    
    public int helper(int[] nums, int l, int r) {
        // track memorizes max sum you can achieve arriving current position`
        int[] track = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            if (i == l) {
                track[i - l] = nums[l];
            } else if (i == l + 1) {
                track[i - l] = Math.max(nums[i], nums[i - 1]);
            } else {
                track[i - l] = Math.max(nums[i] + track[i - l - 2], track[i - l - 1]);
            }
        }
        return track[track.length - 1];
    }
}
