package leetcode;

public class leet62_dp {

}
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n==0){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;

        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if (r==0 && c==0){
                    continue;
                }else if (r==0){
                    dp[r][c] = dp[r][c-1];
                    continue;
                }else if (c==0){
                    dp[r][c] = dp[r-1][c];
                    continue;
                }

                dp[r][c] = dp[r-1][c] + dp[r][c-1];
            }
        }

        return dp[m-1][n-1];
    }
}