package leetcode;

public class leet236 {

}
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
        if (root == null) return null;

        TreeNode result = dfs(root, p, q);

        return result;
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;
        if (root == q || root == p){
            return root;
        }

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if (left != null && right != null) return root;
        if (left != null) return left;
        if (right != null) return right;

        return null; 

    }
}