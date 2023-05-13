package lintcode;

public class lint900 {

}
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

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int closest = Integer.MAX_VALUE;

        while (root != null){
            int val = root.val;
            // System.out.println("root"+val);
            if (Math.abs(target - closest) > Math.abs(target - val)){
                closest = val;
            }
            if (target == val) {
                break;
            }else if (target < val){
                root = root.left;
            }else{
                root = root.right;
            }
        }

        return closest;

    }
}