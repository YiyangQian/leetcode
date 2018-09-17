/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        res = helper(root, "", res);
        return res;
    }
    
    public int helper(TreeNode root, String track, int res) {
        track += root.val;
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(track);
            return res;
        }
        int left, right;
        left = right = 0;
        if (root.left != null) {
            left = helper(root.left, track, res);
        }
        if (root.right != null) {
            right = helper(root.right, track, res);
        }
        return left + right;
    }
}
