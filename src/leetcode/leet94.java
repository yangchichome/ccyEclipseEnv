package leetcode;

public class leet94 {

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.left;
        }

        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            result.add(node.val);
            if (node.right == null){
                node = stack.pop();
                while(!stack.isEmpty() && node == stack.peek().right){
                    node = stack.pop();
                }
            }else{
                node = node.right;
                while(node != null){
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return result;
    }
}