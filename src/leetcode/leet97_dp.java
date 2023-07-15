package leetcode;

public class leet97_dp {

}
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        if (n + m != s3.length()){
            return false;
        }
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i=1; i<=n; i++){
            if (s3.charAt(i-1) == s1.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }else{
                break;
            }
        }

        for(int i=1; i<=m; i++){
            if(s3.charAt(i-1) == s2.charAt(i-1) && dp[0][i-1]){
                dp[0][i] = true;
            }else{
                break;
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(((s3.charAt(i+j-1) == s1.charAt(i-1) && dp[i-1][j])) ||
                ((s3.charAt(i+j-1) == s2.charAt(j-1)) && dp[i][j-1])) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[n][m];
        
    }
}