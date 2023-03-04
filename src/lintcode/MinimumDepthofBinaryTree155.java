package lintcode;

public class MinimumDepthofBinaryTree155 {

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

    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public int minDepth(TreeNode root) {
        // write your code here

        if (root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth +rightDepth + 1;
        }

        return Math.min(leftDepth,rightDepth) + 1;

    }
}