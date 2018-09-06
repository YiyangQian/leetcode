/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<String>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<String> track = new Stack<String>();
        stack.push(root);
        track.push("" + root.val);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            String curPath = track.pop();
            if (cur.left == null && cur.right == null) {
                res.add(curPath);
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                    track.push(curPath + "->" + cur.right.val);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                    track.push(curPath + "->" + cur.left.val);
                }
            }
        }
        return res;
    }
}