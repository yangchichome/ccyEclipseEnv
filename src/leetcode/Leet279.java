package leetcode;

public class Leet279 {

}
class Solution {
    public int numSquares(int n) {
        //dp[i] = dp[i-j*j] + dp[j*j]
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n ; i++){
            dp[i] = n;
            for(int j=1; j*j<=i; j++){
                if(dp[i] > dp[i-j*j] + 1){
                    dp[i] = dp[i-j*j] + 1;
                    // System.out.println(i+", dp[i]:"+dp[i]);
                }
            }
        }

        return dp[n];
    }
}