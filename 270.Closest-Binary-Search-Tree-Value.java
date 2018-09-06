/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        double cur = Math.abs(target - root.val);
        if (root.val < target && root.right != null) {
            int left = closestValue(root.right, target);
            return (Math.abs(left - target) < cur) ? left : root.val;
        }
        if (root.val > target && root.left != null) {
            int right = closestValue(root.left, target);
            return (Math.abs(right - target) < cur) ? right : root.val;
        }
        return root.val;
    }
}