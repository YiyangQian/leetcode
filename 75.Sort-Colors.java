class Solution {
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = partition(nums, l, r);
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }
    
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int endOfSmaller = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                endOfSmaller++;
                swap(nums, i, endOfSmaller);
            }
        }
        swap(nums, endOfSmaller + 1, r);
        return endOfSmaller + 1;
    }
    
    public void swap(int[] nums, int l, int r) {
        int tempt = nums[l];
        nums[l] = nums[r];
        nums[r] = tempt;
    }
}