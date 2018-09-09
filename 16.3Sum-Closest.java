class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int track = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int curSum = nums[l] + nums[r] + nums[i];
                if (curSum == target) {
                    return curSum;
                } else if (curSum < target) {
                    track =  Math.abs(track - target) > Math.abs(curSum - target) ? curSum : track; 
                    l++;
                } else {
                    track =  Math.abs(track - target) > Math.abs(curSum - target) ? curSum : track;
                    r--;
                }
            }
        }
        return track;
    }
}