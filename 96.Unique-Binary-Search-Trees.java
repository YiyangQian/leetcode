class Solution {
    public int numTrees(int n) {
        if (n == 0) return 1;
        int[] track = new int[n + 1];
        track[0] = 1;
        track[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += track[j] * track[i - 1 - j];
            }
            track[i] = sum;
        }
        return track[n];
    }
}
