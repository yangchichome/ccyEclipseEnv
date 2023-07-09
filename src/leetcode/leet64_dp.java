package leetcode;

public class leet64_dp {

}
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (n == 0 || m == 0){
            return 0;
        }

        int[][] dp = new int[m][n];

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if (r == 0 && c == 0){
                    dp[r][c] = grid[0][0];
                    continue;
                }else if (r == 0){
                    dp[r][c] = dp[r][c-1] + grid[r][c];
                    continue;
                }else if (c == 0){
                    dp[r][c] = dp[r-1][c] + grid[r][c];
                    continue;
                }

                dp[r][c] = Math.min(dp[r][c-1], dp[r-1][c]) + grid[r][c];
            }
        }

        return dp[m-1][n-1];
    }
}