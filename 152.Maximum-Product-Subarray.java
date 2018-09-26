class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0], max = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int curMax = Math.max(cur * max, cur * min);
            int curMin = Math.min(cur * max, cur * min);
            max = Math.max(curMax, cur);
            min = Math.min(curMin, cur);
            res = Math.max(res, max);
        }
        return res;
    }
}

 //      2  3  -2   4 
 // max  2  6  -2   4
 // min  2  3  -12  -48
 // res  2  6  6    6
 