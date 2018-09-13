class Solution {
    public boolean search(int[] nums, int target) {
        return helper(nums, target, 0, nums.length - 1);
    }
    
    public boolean helper(int[] nums, int target, int l, int r) {
        if (l > r) return false;
        int mid = l + (r - l) / 2;
        if (target == nums[mid]) return true;
        if (nums[mid] <  nums[r] || nums[mid] < nums[l]){
            //if right part is sorted
            if (nums[mid] < target && target <= nums[r]) {
                return helper(nums, target, mid + 1, r);
            } else {
                return helper(nums, target, l, mid - 1);
            }  
        } else if (nums[mid] > nums[l] || nums[mid] > nums[r]){
            if (nums[mid] < target || target < nums[l]) {
                return helper(nums, target, mid + 1, r);          
            } else {
                return helper(nums, target, l, mid - 1);
            }
        } else {
            return helper(nums, target, l, r - 1);
        }
    }
}

// 0,0,1,2,2,5,6
// 6,0,0,1,2,2,5
// 5,6,0,0,1,2,2
// 2,5,6,0,0,1,2
// 2,2,5,6,0,0,1
// 1,2,2,5,6,0,0,


// 1 1 3 1