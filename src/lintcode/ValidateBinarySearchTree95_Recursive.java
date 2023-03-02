package lintcode;

public class ValidateBinarySearchTree95_Recursive {

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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    class resultType {
        public boolean isBST;
        public TreeNode maxNode,minNode;
        public resultType(boolean isBST){
            this.isBST = isBST;
            this.maxNode = null;
            this.minNode = null;
        }
    }
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return diviAnRecursive(root).isBST;
    }
    
    public resultType diviAnRecursive (TreeNode root){
        if (root == null) return new resultType(true);

        resultType leftRoot = diviAnRecursive(root.left);
        resultType rightRoot = diviAnRecursive(root.right);

        if (!leftRoot.isBST || !rightRoot.isBST) return new resultType(false);
        if (leftRoot.maxNode != null && leftRoot.maxNode.val >= root.val) return new resultType(false);
        if (rightRoot.minNode != null && rightRoot.minNode.val <= root.val) return new resultType(false);

        resultType result = new resultType(true);
        result.minNode = leftRoot.minNode != null ? leftRoot.minNode : root;
        result.maxNode = rightRoot.maxNode != null ? rightRoot.maxNode : root;

        return result;
    }
}