package leetcode;

public class leet107 {

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for (int i=0; i<n; i++){
                TreeNode node = queue.poll();
                sublist.add(node.val);

                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
            Collections.reverse(sublist);

            result.add(sublist);
        }
        
        Collections.reverse(result);    
        return result;
    }
}