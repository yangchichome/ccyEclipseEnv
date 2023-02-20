package lintcode;

public class BinaryTreeZigzagLevelOrderTraversa71l {

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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        boolean isForward = true;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<Integer>();
            for (int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                subList.add(treeNode.val);
                if(treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.offer(treeNode.right);
                }
            } 
            if (!isForward){
                Collections.reverse(subList);
            }

            result.add(subList);

            isForward = !isForward;
        }

        return result;
    }
}