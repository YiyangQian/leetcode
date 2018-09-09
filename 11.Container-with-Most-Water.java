class Solution {
    public int maxArea(int[] height) {
        int track = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            track = Math.max(track, (r - l) * Math.min(height[l], height[r]));
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return track;
    }
}