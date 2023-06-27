package leetcode;

public class leet110 {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class resultType {
    boolean isBalance;
    int maxDepth;
    public resultType(boolean isBalance, int maxDepth){
        this.isBalance = isBalance;
        this.maxDepth = maxDepth;
    }
} 
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if (root == null) return true;

        resultType result = dfs(root);

        return result.isBalance;
    }

    public resultType dfs(TreeNode root){
        if (root == null)
            return new resultType(true, 0);

        resultType left = dfs(root.left);
        resultType right = dfs(root.right);

        if (!left.isBalance || !right.isBalance){
            return new resultType(false, -1);
        }
        if (Math.abs(left.maxDepth - right.maxDepth) > 1){
            return new resultType(false, -1);
        }

        return new resultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);

    }


}