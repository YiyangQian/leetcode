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
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode tempt = root.right;
        root.right = root.left;
        root.left = null;
        flatten(root.right);
        while (root.right != null) root = root.right;
        root.right = tempt;
        flatten(root.right);
    }
}