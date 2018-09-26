class Solution {
    public int findMin(int[] nums) {
        // the idea of binary sort is able to get rid of half every time
        return helper(nums, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int l, int r) {
        int res = Integer.MAX_VALUE;
        if (l == r) return nums[l];
        int mid = l + (r - l) / 2;
        if (nums[mid] >= nums[l]) {
            //left part is sorted
            res = Math.min(res, nums[l]);
            res = Math.min(res, helper(nums, mid + 1, r));
        } else {
            //right part is sorted
            res = Math.min(res, nums[mid]);
            res = Math.min(res, helper(nums, l, mid - 1));
        }
        return res;
    }
}

// 0 1 2  3 4 5
// 5 0 1  2 3 4
// 4 5 0  1 2 3
// 3 4 5 0 1 2
// 2 3 4 5 0 1 
// 1 2 3 4 5 0
