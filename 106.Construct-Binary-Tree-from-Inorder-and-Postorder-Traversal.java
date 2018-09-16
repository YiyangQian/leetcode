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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    public TreeNode helper(int index, int l, int r, int[] inorder, int[] postorder) {
        if (l > r) return null;
        if (l == r) return new TreeNode(inorder[l]);
        TreeNode root = new TreeNode(postorder[index]);
        int indexInInorder = 0;
        for (int i = l; i <= r; i++) {
            if (inorder[i] == postorder[index]) {
                indexInInorder = i;
            }
        }
        int leftCount = indexInInorder - l;
        int rightCount = r - indexInInorder;
        root.left = helper(index - 1 - rightCount, l, indexInInorder - 1, inorder, postorder);
        root.right = helper(index - 1, indexInInorder + 1, r, inorder, postorder);
        return root;
    }
}