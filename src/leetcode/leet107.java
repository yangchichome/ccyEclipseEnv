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
        

        if(root == null) return result;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int s = queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i=0; i<s; i++){
                TreeNode n = queue.poll();
                ans.add(n.val);

                if (n.left != null){
                    queue.offer(n.left);
                }
                if(n.right != null){
                    queue.offer(n.right);
                }
            }

            result.add(ans);
        }

        Collections.reverse(result);

        return result;
    }
}