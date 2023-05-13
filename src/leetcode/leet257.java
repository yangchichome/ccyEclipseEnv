package leetcode;

public class leet257 {

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;

        List<String> pathL = binaryTreePaths(root.left);
        List<String> pathR = binaryTreePaths(root.right);

        for (String path : pathL){
            paths.add(root.val+"->"+path);
        }
        for (String path : pathR){
            paths.add(root.val+"->"+path);
        }

        if (paths.size() == 0){
            paths.add(""+ root.val);
        }

        return paths;
    }
}