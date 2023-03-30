package lintcode;

public class Lint109 {

}
public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        if (triangle[0] == null || triangle[0].length == 0){
            return -1;
        }

        int n = triangle.length;
        int[][] dp = new int[2][n];
        
        dp[0][0] = triangle[0][0];
        for (int i=1; i<n; i++){
            dp[i % 2][0] = dp[(i-1) % 2][0] + triangle[i][0];
            dp[i % 2][i] = dp[(i-1) % 2][i-1] + triangle[i][i];
            for (int j=1; j<i; j++){
                dp[i % 2][j] = Math.min(dp[(i-1) % 2][j], dp[(i-1) % 2][j-1]) + triangle[i][j];
            }
        }

        int min = dp[(n-1) % 2][0];
        for (int i=1; i<n; i++){
            min = Math.min(min, dp[(n-1) % 2][i]);
        }
        return min;
    }
}