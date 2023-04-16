package leetcode;

public class leet1143_dp_rolling {

}
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int [2][m+1];

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                dp[i%2][j] = Math.max(dp[i%2][j-1], dp[(i-1)%2][j]);
                if (text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i%2][j] = Math.max(dp[i%2][j], dp[(i-1)%2][j-1]+1);
                }
            }
        }

        return dp[n%2][m];
    }
}