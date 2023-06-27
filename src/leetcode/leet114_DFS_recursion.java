package leetcode;

public class leet114_DFS_recursion {

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
class Solution {
    public void flatten(TreeNode root) {
        
        dfs(root);

    }

    private TreeNode dfs(TreeNode root){

        if (root == null){
            return null;
        }
             
        TreeNode leftlast = dfs(root.left);
        TreeNode rightlast = dfs(root.right);

        if (leftlast != null){
            leftlast.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        if (rightlast != null) return rightlast;
        if (leftlast != null) return leftlast;

        return root;


    }
}