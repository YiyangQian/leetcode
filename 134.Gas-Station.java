class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (isRight(gas, cost, i)) return i;
        }
        return -1;
    }
    
    public boolean isRight(int[] gas, int[] cost, int start) {
        int track = 0;
        for (int i = 0; i < gas.length; i++) {
            track = track + gas[(start + i) % gas.length] - cost[(start + i) % gas.length];
            if (track < 0) return false;
        }
        return true;
    }
}