package leetcode;

public class Leet114_DFS_stack {

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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.pop();

            if (node == null) break;;
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
            
            // System.out.println("val: "+node.val);
            node.left = null;
            if (stack.empty()){
                node.right = null;
            }else {
                node.right = stack.peek();
            }
        }
    }
}