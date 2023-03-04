package lintcode;

public class InorderSuccessorinBST448 {

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode preNode = null;

        while(root != null && root.val != p.val){
            if (root.val > p.val){
                preNode = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }

        if (root == null) return null;
        if (root.right == null) return preNode;

        root = root.right;
        while(root.left != null){
            root = root.left;
        }

        return root;
    }
}