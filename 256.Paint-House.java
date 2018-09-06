class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0)
            return 0;
        int[][] track = new int[costs.length][costs[0].length];
        track[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            track[i][0] = costs[i][0] + Math.min(track[i - 1][1], track[i - 1][2]);
            track[i][1] = costs[i][1] + Math.min(track[i - 1][0], track[i - 1][2]);
            track[i][2] = costs[i][2] + Math.min(track[i - 1][0], track[i - 1][1]);
        }
        return Math.min(track[track.length - 1][0], Math.min(track[track.length - 1][1], track[track.length - 1][2]));
    }
}