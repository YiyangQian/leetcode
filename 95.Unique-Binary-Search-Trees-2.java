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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        return helper(1, n);
    }
    
    public List<TreeNode> helper(int min, int max) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (min > max) {
            res.add(null);
            return res;
        }
        if (min == max) {
            TreeNode root = new TreeNode(min);
            res.add(root);
            return res;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> left = helper(min, i - 1);
            List<TreeNode> right = helper(i + 1, max);
            
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}