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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        List<Integer> cur = new LinkedList<Integer>();
        helper(res, cur, root, sum);
        return res;
     }
    
    public void helper(List<List<Integer>> res, List<Integer> cur, TreeNode root, int target) {
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                res.add(new LinkedList<Integer>(cur));
            }
        } else {
            if (root.left != null) {
                helper(res, new LinkedList<Integer>(cur), root.left, target - root.val);
            }
            if (root.right != null) {
                helper(res, new LinkedList<Integer>(cur), root.right, target - root.val);
            }
        }
    }
}