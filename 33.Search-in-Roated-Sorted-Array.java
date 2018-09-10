class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
    
    public int binarySearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < nums[r]) {
            if (target > nums[mid] && target <= nums[r]) {
                return binarySearch(nums, target, mid + 1, r);
            } else {
                return binarySearch(nums, target, l, mid - 1);
            }
        } else {
            if (target >= nums[l] && target < nums[mid]) {
                return binarySearch(nums, target, l, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, r);
            }
        }
    }
}

// 0,1,2,4,5,6,7
// 7,0,1,2,4,5,6
// 6,7,0,1,2,4,5
// 5,6,7,0,1,2,4
// 4,5,6,7,0,1,2
// 2,4,5,6,7,0,1
// 1,2,4,5,6,7,0
