class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // if (nums.length < 2 || k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.ceiling(nums[i]) != null && set.ceiling(nums[i]) <= t + nums[i]) return true;
            if (set.floor(nums[i]) != null && nums[i] <= t + set.floor(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
