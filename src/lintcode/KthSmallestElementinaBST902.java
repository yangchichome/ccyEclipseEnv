package lintcode;

public class KthSmallestElementinaBST902 {

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
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        for (int i=0;i<k-1;i++){
            TreeNode node = stack.peek();

            if (node.right == null){
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node){
                    node = stack.pop();
                }
            } else{
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return stack.peek().val;
    }
}