package leetcode;

public class leet63_dp {

}
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        if(n == 0 || m == 0){
            return 0;
        }

        int[][] dp = new int[n][m];
        if (obstacleGrid[0][0] == 0){
            dp[0][0] = 1;
        }

        for(int r=0; r<n; r++){
            for(int c=0; c<m; c++){
                if (r==0 && c==0){
                    continue;
                }else if (obstacleGrid[r][c] == 1){
                    continue;
                }else if (r == 0){
                    dp[r][c] = dp[r][c-1];
                    continue;
                }else if (c == 0){
                    dp[r][c] = dp[r-1][c];
                    continue;
                }

                dp[r][c] = dp[r][c-1] + dp[r-1][c];
            }
        }

        return dp[n-1][m-1];
    }
}