package lintcode;
//88 · Lowest Common Ancestor of a Binary Tree
public class Lint88 {

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


    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code 
        if(root == null) return null;
        
        if(root == A || root == B){
            return root;
        }

        TreeNode leftNode = lowestCommonAncestor(root.left,A,B);
        TreeNode rightNode = lowestCommonAncestor(root.right,A,B);

        if(leftNode != null && rightNode != null) return root;
        if (leftNode != null){
            return leftNode;
        }
        if (rightNode != null){
            return rightNode;
        }

        return null;

    }
}