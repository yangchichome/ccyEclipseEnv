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

class treeInfo{
    public int max;
    public boolean balance;
    public treeInfo(int max, boolean balance){
        this.max = max;
        this.balance = balance;
    }
}
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        treeInfo result = dfs(root); 
        
        return result.balance;
    }

    private treeInfo dfs(TreeNode root){
        if (root == null){
            return new treeInfo(0, true);
        }

        treeInfo linfo = dfs(root.left);
        treeInfo rinfo = dfs(root.right);

        if (!linfo.balance || !rinfo.balance){
            return new treeInfo(0, false);
        }

        if (Math.abs(linfo.max - rinfo.max) > 1){
            return new treeInfo(0, false);
        }

        return new treeInfo(Math.max(linfo.max, rinfo.max)+1, true);             
    }
}