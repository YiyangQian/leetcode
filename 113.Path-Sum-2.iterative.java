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
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<List<Integer>> track = new Stack<List<Integer>>();
        Stack<Integer> target = new Stack<Integer>();
        stack.push(root);
        track.push(cur);
        target.push(sum);
        while(!stack.isEmpty()) {
            root = stack.pop();
            cur = track.pop();
            cur.add(root.val);
            int tar = target.pop();
            if (root.left == null && root.right == null) {
                if (root.val == tar) {
                    res.add(new LinkedList<Integer>(cur));
                }
            } else {
                if (root.left != null) {
                    stack.push(root.left);
                    track.push(new LinkedList<Integer>(cur));
                    target.push(tar - root.val);
                }
                if (root.right != null) {
                    stack.push(root.right);
                    track.push(new LinkedList<Integer>(cur));
                    target.push(tar - root.val);
                }
            }
        }
        return res;
     }
}