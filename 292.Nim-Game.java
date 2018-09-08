class Solution {
    public boolean canWinNim(int n) {
        int residual = n % 4;
        if (residual == 1 || residual == 2 || residual == 3) return true;
        return false;
    }
}

// left number
// 1                win
// 2                win
// 3                win
// 4                loss

// 5                win     
// 6                win     
// 7                win      
// 8                loss

// 9                win
// 10               win
// 11               win
// 12               loss

// 13               win
// 14               win
// 15               win
