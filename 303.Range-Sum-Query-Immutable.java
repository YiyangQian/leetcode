class NumArray {
    
    int[] track;
    public NumArray(int[] nums) {
        track = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                track[i] = nums[i];
            } else {
                track[i] = nums[i] + track[i - 1];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if (i <= 0) return track[j];
        return track[j] - track[i - 1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

