package lintcode;

public class lint448 {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here

        TreeNode result = null;

        while(root != null){
            if (root.val <= p.val){
                root = root.right;
            }else{
                result = root;
                root = root.left;
            }
        }

        return result;
    }
}