package leetcode;

public class leet97 {

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
        
        List<Integer> result = inorder(root);

        return result;
    }

    private List<Integer> inorder(TreeNode root){
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        while(root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()){
            TreeNode node = stack.peek();
            result.add(node.val);
            if (node.right == null) {
                node = stack.pop();

                while (!stack.isEmpty() && stack.peek().right == node){
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