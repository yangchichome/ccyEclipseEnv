package leetcode;

public class Leet654_Recursive {

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;

        return MBT(nums, 0, nums.length-1);
    }

    public TreeNode MBT(int[] nums, int start, int end){
        if (start > end){
            return null;
        }

        int maxIndex = start;
        for (int i=start; i<=end; i++){
            if (nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = MBT(nums, start, maxIndex-1);
        root.right = MBT(nums, maxIndex+1, end);

        return root;
    }
}