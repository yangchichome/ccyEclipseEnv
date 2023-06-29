package lintcode;

public class lintt595 {

}
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here

        return helper(root, null, 0);
    }

    private int helper(TreeNode root, TreeNode parent, int longestLength){

        if (root == null) return 0;

        int length = (parent != null && parent.val + 1 == root.val) ? longestLength+1 : 1;

        int left = helper(root.left, root, length);
        int right = helper(root.right, root, length);

        return Math.max(length, Math.max(left, right));
    }
}