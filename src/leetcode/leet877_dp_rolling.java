package leetcode;

public class leet877_dp_rolling {

}
class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[2][n];

        for (int len=2; len<=n; len++){
            for(int i=0; i<n-len+1; i++){
                int j = i + len - 1;
                dp[i%2][j] = Math.max(piles[i] - dp[(i+1)%2][j], piles[j] - dp[i%2][j-1]); 
            }
        }
        return dp[0][n-1] > 0;
    }
}