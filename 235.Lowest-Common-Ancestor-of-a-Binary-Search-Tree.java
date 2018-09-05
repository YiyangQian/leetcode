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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new LinkedList<TreeNode>();
        List<TreeNode> l2 = new LinkedList<TreeNode>();
        l1.add(root);
        l2.add(root);
        TreeNode searcher = root;
        while (searcher.val != p.val) {
            searcher = (searcher.val > p.val) ? searcher.left : searcher.right;
            l1.add(searcher);
        }
        searcher = root;
        while (searcher.val != q.val) {
            searcher = (searcher.val > q.val) ? searcher.left : searcher.right;
            l2.add(searcher);
        }
        TreeNode result = root;
        for (int i = 0; i < l1.size() && i < l2.size(); i++) {
            TreeNode c1 = l1.get(i);
            TreeNode c2 = l2.get(i);
            if (c1 == c2) result = c1;
        }
        return result;
    }
}