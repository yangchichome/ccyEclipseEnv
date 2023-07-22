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

        int count=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            // System.out.println("size: "+size);
            List<Integer> tmp = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode tree = queue.poll();
                // System.out.println("    tree: "+tree.val);
                if (tree != null){
                    tmp.add(tree.val);

                    if(tree.left != null){
                        queue.offer(tree.left);
                    }
                    if(tree.right != null){
                        queue.offer(tree.right);
                    }
                }
            }
            if (count%2 == 1){
                tmp = reverseList(tmp);
            }
            count++;
            result.add(tmp);
        }

        return result;
    }

    private List<Integer> reverseList(List<Integer> tmp){
        List<Integer> newList = new ArrayList<>();
        for(int i=tmp.size()-1; i>=0; i--){
            newList.add(tmp.get(i));
        }

        return newList;
    }
}