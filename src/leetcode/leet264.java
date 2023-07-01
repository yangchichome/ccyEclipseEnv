package leetcode;

public class leet264 {

}
class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int s2=0, s3=0, s5=0;
        for(int i=1; i<n; i++){
            dp[i] = Math.min(dp[s2]*2, Math.min(dp[s3]*3, dp[s5]*5));

            if (dp[i] == dp[s2]*2){
                s2++;
            }
            if (dp[i] == dp[s3]*3){
                s3++;
            }
            if (dp[i] == dp[s5]*5){
                s5++;
            }
        }

        return dp[n-1];
    }
}