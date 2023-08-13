package leetcode;

public class leet221_dp {

}
class Solution {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j] = Max(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) + 1;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;

        int maxSize = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == '1'){
                    if(i == 0 || j == 0){
                        dp[i][j] = matrix[i][j] - '0';
                    }else{
                        dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) + 1;
                    }
                    if (dp[i][j] > result){
                        result = dp[i][j];
                    } 
                }
            }
        }

        return result*result;
    }
}