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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode helper(int index, int l, int r, int[] preorder, int[] inorder) {
        if (l > r) return null;
        if (l == r) return new TreeNode(inorder[l]);
        TreeNode root = new TreeNode(preorder[index]);
        int indexInInorder = 0;
        for (int i = l; i <= r; i++) {
            if (inorder[i] == preorder[index]) {
                indexInInorder = i;
            }
        }
        root.left = helper(index + 1, l, indexInInorder - 1, preorder, inorder);
        root.right = helper(index + indexInInorder - l + 1, indexInInorder + 1, r, preorder, inorder);
        return root;
    }
}