package lintcode;

public class ValidateBinarySearchTree95_Iterative {

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
    public boolean isValidBST(TreeNode root) {
        // write your code here
        Stack<TreeNode> stack = new Stack<>();

        while(root!=null){
            stack.push(root);
            root = root.left;
        }

        TreeNode lastNode = null;
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if (lastNode != null && lastNode.val >= node.val){
                return false;
            }
            lastNode = node;

            if (node.right == null) {
                node = stack.pop();
                while(!stack.isEmpty() && node == stack.peek().right){
                    node = stack.pop();
                }
            }else {
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return true;
    }
}