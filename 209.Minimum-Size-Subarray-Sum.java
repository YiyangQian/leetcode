class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int track = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                track = Math.min(track, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return track == Integer.MAX_VALUE ? 0 : track;
    }
}
