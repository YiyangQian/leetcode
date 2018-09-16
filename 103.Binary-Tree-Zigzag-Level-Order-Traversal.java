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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> l = new LinkedList<Integer>();
        int level = 0;
        q.add(root);
        q.add(null);
        TreeNode cur = null;
        while (!(q.size() == 1 && cur == null)) {
            cur = q.poll();
            if (cur == null) {
                level++;
                if (level % 2 == 0) l = reverseList(l);
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
    
    public List<Integer> reverseList(List<Integer> l) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = l.size() - 1; i >= 0; i--) {
            res.add(l.get(i));
        }
        return res;
    }
}