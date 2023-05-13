package leetcode;

public class leet103 {

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReverse = false;

        while (!queue.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int s = queue.size();
            for (int i=0; i<s; i++){
                TreeNode node = queue.poll();
                sublist.add(node.val);

                if (node.right != null){
                    queue.offer(node.right);
                }
                if (node.left != null){
                    queue.offer(node.left);
                }
            }

            if (!isReverse){
                Collections.reverse(sublist);
            }

            isReverse = !isReverse;

            result.add(sublist);
        }

        return result;
    }
}