package leetcode;

public class leet64_dp {

}
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (i == 0 && j==0){
                    dp[i][j] = grid[i][j];
                    continue;
                }else if (i == 0){
                    dp[0][j] = dp[0][j-1] + grid[0][j];
                    continue;
                }else if (j == 0){
                    dp[i][0] = dp[i-1][0] + grid[i][0];
                    continue;
                }

                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[m-1][n-1];

    }
}