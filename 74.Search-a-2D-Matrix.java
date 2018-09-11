class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int r = rowNum * colNum - 1;
        int l = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cur = matrix[mid / colNum][mid % colNum];
            if (cur == target) {
                return true;
            } else if (cur < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}