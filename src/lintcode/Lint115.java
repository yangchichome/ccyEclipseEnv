package lintcode;

public class Lint115 {

}
public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if (n == 0 || m == 0) return 0;

        int[][] dp = new int[n][m];

        for (int i=0; i<n; i++){
            if (obstacleGrid[i][0] != 1){
                dp[i][0] = 1;
            }else{
                break;
            }
        }
        for (int j=0; j<m; j++){
            if (obstacleGrid[0][j] != 1){
                dp[0][j] = 1;
            }else{
                break;
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if (obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}