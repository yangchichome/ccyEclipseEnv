package leetcode;

public class leet221_dp {

}
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        // System.out.println("result: "+result);
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){

                if (i == 0 || j == 0) {
                    // System.out.println("i or j = 0");
                    dp[i][j] = matrix[i][j] - '0';
                }else if (matrix[i][j] == '1'){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1],dp[i-1][j-1])) + 1;
                    // System.out.println("i: "+i+" j: "+j+" dp: "+dp[i][j]);
                }else {
                    dp[i][j] = 0;
                }
                // System.out.println("i: "+i+" j: "+j+" dp: "+dp[i][j]);
                result = Math.max(dp[i][j],result);
                // System.out.println("i: "+i+" j: "+j+" result: "+result);
            } 
        }

        return result*result;   
    }
}