class Solution {
    public boolean isUgly(int num) {
        if (num == 0)
            return false;
        num = divideByOneNumberAsMuchAsPossible(num, 2);
        num = divideByOneNumberAsMuchAsPossible(num, 3);
        num = divideByOneNumberAsMuchAsPossible(num, 5);
        return num == 1;
    }

    public int divideByOneNumberAsMuchAsPossible(int num, int divider) {
        while (num % divider == 0)
            num = num / divider;
        return num;
    }
}