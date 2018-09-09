class Solution {
    public int findNthDigit(int n) {
        int length = 1;
        int start = 1;
        long count = 9;
        while (n - count * length > 0) {
            n -= count * length;
            length++;
            start = start * 10;
            count = count * 10;
        }
        start += (n - 1) / length;
        int index = (n - 1) % length;
        String res = Integer.toString(start);
        return Character.getNumericValue(res.charAt(index));
    }
}
