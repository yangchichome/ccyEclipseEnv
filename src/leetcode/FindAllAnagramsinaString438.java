package leetcode;

public class FindAllAnagramsinaString438 {

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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        Long sum = (long) targetSum;

        return pathSum(root.left,targetSum) + pathSum(root.right,targetSum) + findPath(root,sum);
    }
    public int findPath(TreeNode root, Long targetSum){
        if (root == null) return 0;

        int result = 0;

        if (root.val == targetSum) {
            result++;   
        }
        result += findPath(root.left, targetSum - (long) root.val);

        result += findPath(root.right, targetSum - (long) root.val);

        return result;
    }
}