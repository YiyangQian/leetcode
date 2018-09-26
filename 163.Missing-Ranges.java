class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<String>();
        if (nums.length == 0 || nums == null){ 
            if (lower == upper) {
                res.add("" + lower);
            } else {
                res.add(lower + "->" + upper);
            }
            return res;
        }
        addHead(res, lower, nums[0]);
        for (int i = 0; i < nums.length - 1; i++) {
            addInterval(res, nums[i], nums[i + 1]);
        }
        addTail(res, nums[nums.length - 1], upper);
        return res;
    }
    
    public void addInterval(List<String> res, int num1, int num2) {
        if (num1 == num2 || num2 - num1 == 1)
            return;
        if (num2 - num1 == 2) {
            res.add("" + (num1 + 1));
        } else {
            res.add((num1 + 1) + "->" + (num2 - 1));
        }
     }
    
    public void addHead(List<String> res, int lower, int start) {
        if (lower == start)
            return;
        if (start - lower == 1) {
            res.add("" + lower);
        } else {
            res.add(lower + "->" + (start - 1));
        }
    }
    
    public void addTail(List<String> res, int end, int upper) {
        if (end == upper)
            return;
        if (upper - end == 1) {
            res.add("" + upper);
        } else {
            res.add((end + 1) + "->" + upper);
        }
    }
}
