class Solution {
    public void nextPermutation(int[] nums) {
        int target = nums.length - 2;
        while (target >= 0 && nums[target] >= nums[target + 1]) target--;
        if (target == -1) {
            reverse(nums, 0);
        } else {
            int justLarger = target + 1;
            while (justLarger < nums.length && nums[justLarger] > nums[target]) justLarger++;
            justLarger--;
            swap(nums, target, justLarger);
            reverse(nums, target + 1);
        }
    }
    
    public void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    
    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}