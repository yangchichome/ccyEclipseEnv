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
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }

        TreeNode leftA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightA = lowestCommonAncestor(root.right, p, q);

        if (leftA != null && rightA != null){
            return root;
        }
        if(leftA != null){
            return leftA;
        }
        if(rightA != null){
            return rightA;
        }

        return null;
    }
}