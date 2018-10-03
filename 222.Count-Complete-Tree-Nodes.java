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
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        if (h < 0) return 0;
        int rightHeight = getHeight(root.right);
        if (rightHeight + 1 == h) {
            //left child tree is complete (h - 1)
            return (1 << h) + countNodes(root.right);
        } else {
            //right child tree is complete (h - 2)
            return (1 << h - 1) + countNodes(root.left);
        }
    }
    
    public int getHeight(TreeNode root) {
        if (root == null) return -1;
        return 1 + getHeight(root.left);
    }
}
