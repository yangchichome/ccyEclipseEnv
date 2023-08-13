package leetcode;

public class leet304_dp {

}
class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        dp = new int[m][m];

        dp[0][0] = matrix[0][0];
        for(int i=1; i<m; i++){
            dp[0][i] = dp[0][i-1] + matrix[0][i];
            dp[i][0] = dp[i-1][0] + matrix[i][0]; 
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum2 = dp[row2][col2];
        int sum1 = dp[row1-1][col1-1];
        int sumL = dp[row2][col1-1];
        int sumT = dp[row1-1][col2];
        return sum2 - sumL -sumT + sum1;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */