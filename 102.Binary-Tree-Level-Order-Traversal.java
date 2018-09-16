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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        List<Integer> l = new LinkedList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        TreeNode cur = null;
        while (!(q.size() == 1 && cur == null)) {
            cur = q.poll();
            if (cur == null) {
                res.add(new LinkedList<Integer>(l));
                l = new LinkedList<Integer>();
                q.add(null);
            } else {
                l.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
        }
        return res;
    }
}