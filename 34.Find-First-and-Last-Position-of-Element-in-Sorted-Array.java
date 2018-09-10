class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[] {-1, -1};
        int found = binarySearch(nums, target, 0, nums.length - 1);
        int[] res = new int[2];
        if (found == -1) {
            res[0] = -1;
            res[1] = -1;
        } else {
            int left = getLeftBound(nums, target, 0, found);
            int right = getRightBound(nums, target, found, nums.length);
            res[0] = left;
            res[1] = right;
        }
        return res;
    }
    
    public int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, r);
        } else {
            return binarySearch(nums, target, l, mid - 1);
        }
    }
    
    public int getLeftBound(int[] nums, int target, int l, int r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target && (mid == 0 || nums[mid] > nums[mid - 1])) return mid;
        if (nums[mid] < target) {
            return getLeftBound(nums, target, mid + 1, r);
        } else {
            return getLeftBound(nums, target, l, mid - 1);
        }
    }
    
    public int getRightBound(int[] nums, int target, int l, int r) {
        int mid = l + (r - l) / 2;
        if (nums[mid] == target && (mid == nums.length - 1 || nums[mid] < nums[mid + 1])) return mid;
        if (nums[mid] > target) {
            return getRightBound(nums, target, l, mid - 1);
        } else {
            return getRightBound(nums, target, mid + 1, r);
        }
    }
}