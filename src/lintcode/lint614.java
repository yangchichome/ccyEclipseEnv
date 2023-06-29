package lintcode;

public class lint614 {

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

class ResultType{
    int maxLength;
    int maxUp;
    int maxDown;
    public ResultType(int maxLength, int maxUp, int maxDown){
        this.maxLength = maxLength;
        this.maxUp = maxUp;
        this.maxDown = maxDown;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // write your code here

        return dfs(root).maxLength;
    }

    private ResultType dfs(TreeNode root){
        if (root == null){
            return new ResultType(0,0,0);
        }

        int up = 0, down = 0;
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);

        if (root.left != null){
            if (root.left.val+1 == root.val){
                down = Math.max(down, left.maxDown+1);
            }
            if (root.left.val-1 == root.val){
                up = Math.max(up, left.maxUp+1);
            }
        }

        if(root.right != null){
            if (root.right.val+1 == root.val){
                down = Math.max(down, right.maxDown+1);
            }
            if (root.right.val-1 == root.val){
                up = Math.max(up, right.maxUp+1);
            }
        }

        int length = up + 1 +down;
        length = Math.max(length, Math.max(left.maxLength, right.maxLength));

        return new ResultType(length, up, down);

    }
}