package lintcode;

public class BinaryTreeLevelOrderTraversal69 {

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
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List answers = new ArrayList<>();

        if (root == null) return answers;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> Level = new ArrayList<>();
            int size = queue.size();
            for (int i=1;i <= size;i++){
                TreeNode head = queue.poll();
                Level.add(head.val);
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null){
                    queue.offer(head.right);
                }
            }

            answers.add(Level);
        }
        return answers;
    }
}