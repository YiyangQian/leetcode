class Solution {
    public int removeDuplicates(int[] nums) {
        int anchor = 0;
        for (int cur : nums) {
            if (anchor < 2 || cur > nums[anchor - 2]) {
                nums[anchor] = cur;
                anchor++;
            }
        }
        return anchor;
    }
}