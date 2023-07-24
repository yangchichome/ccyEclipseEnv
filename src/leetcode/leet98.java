package leetcode;

public class leet98 {

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
class resultType{
    boolean isValid;
    int max;
    int min;
    public resultType(boolean isValid, int max, int min){
        this.isValid = isValid;
        this.max = max;
        this.min = min;
    }
}
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        resultType result = dfs(root);

        return result.isValid;
    }

    private resultType dfs(TreeNode root){
        if (root == null){
            return new resultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        resultType leftR = dfs(root.left);
        resultType rightR = dfs(root.right);
        
        if (!leftR.isValid || !rightR.isValid){
            return new resultType(false, 0, 0);
        }

        if ((root.left != null && leftR.max >= root.val) || (root.right != null && rightR.min <= root.val)){
            return new resultType(false, 0, 0);
        }

        return new resultType(true, Math.max(rightR.max, root.val), Math.min(leftR.min, root.val));
    }
}