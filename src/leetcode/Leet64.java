package leetcode;

public class Leet64 {

}
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];

        int old = 0;
        int now = 0;
        for (int i=0; i<m; i++){
            old = now;
            now = 1 - now;
            for (int j=0; j<n; j++){
                if (i == 0 && j == 0){
                    dp[now][j] = grid[0][0];
                    continue;
                } 

                dp[now][j] = Integer.MAX_VALUE;
                if (i > 0) {
                    dp[now][j] = Math.min(dp[old][j], dp[now][j]);
                }

                if (j > 0){
                    dp[now][j] = Math.min(dp[now][j-1], dp[now][j]);
                }

                dp[now][j] += grid[i][j];
            }
        }

        return dp[now][n-1];
    }
}