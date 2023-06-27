package leetcode;

public class leet230 {

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
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Stack<TreeNode> stack = new Stack<>();

        while (root != null){
            stack.push(root);
            root = root.left;
        }

        for (int i=0; i<k-1; i++){

            TreeNode node = stack.peek();

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && node == stack.peek().right){
                    node = stack.pop();
                }
            }else{
                node = node.right;
                while (node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return stack.peek().val;
    }
}