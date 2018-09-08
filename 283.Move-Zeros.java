class Solution {
    public void moveZeroes(int[] nums) {
        int anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[anchor] = nums[i];
                if (i != anchor) nums[i] = 0;
                anchor++;
            }
        }
    }
}
