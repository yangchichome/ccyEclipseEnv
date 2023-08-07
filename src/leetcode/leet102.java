package leetcode;

public class leet102 {

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        // if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelResult = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if (node != null){
                    levelResult.add(node.val);
                    if(node.left != null){
                        queue.offer(node.left);
                    }
                    if(node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
            result.add(levelResult);
        }

        return result;
    }
}