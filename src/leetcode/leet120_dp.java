package leetcode;

public class leet120_dp {

}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];

        dp[0][0] = triangle.get(0).get(0);
        for (int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
        }

        for(int i=1; i<n; i++){
            for (int j=1; j<i; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
            }
        }

        int minPath = dp[n-1][0];
        for(int i=1; i<n; i++){
            if (dp[n-1][i] < minPath){
                minPath = dp[n-1][i];
            }
        }

        return minPath;
    }
}