class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            boolean left = i - 1 > 0 && nums[i] == nums[i - 1];
            boolean right = i + 1 < nums.length && nums[i] == nums[i + 1];
            if (!left && !right) return nums[i];
        }
        return -1;
    }
}