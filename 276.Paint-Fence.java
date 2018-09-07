class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        int sameColor = 0, diffColor = k;
        for (int i = 1; i < n; i++) {
            int tempt = diffColor;
            diffColor = (sameColor + diffColor) * (k - 1);
            sameColor = tempt;
        }
        return sameColor + diffColor;
    }
}