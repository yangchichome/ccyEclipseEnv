package leetcode;

public class leet437 {

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
    public int pathSum(TreeNode root, int targetSum) {
        
        if (root == null) return 0;

        return pathSum(root.left, targetSum) + pathSum(root.right, targetSum) + fullNode(root, (long)targetSum);
    }

    private int fullNode(TreeNode root, long sum){
        if (root == null) return 0;

        int res = 0;
        if (root.val == sum) {
            res++;
        }

        res += fullNode(root.left, sum - root.val);
        res += fullNode(root.right, sum - root.val);

        return res;
    }
}