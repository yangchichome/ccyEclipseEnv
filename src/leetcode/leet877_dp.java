package leetcode;

public class leet877_dp {

}
class Solution {
    private int[][] dp;

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += piles[i];
        }
        
        return dfs(piles, 0, n-1) > sum/2; 
    }
    private int dfs(int[] piles, int l, int r){
        if (l > r) return 0;
        if (dp[l][r] != 0) return dp[l][r];

        boolean isEven = (r-l)%2 == 0 ? true : false;
        int left = isEven? piles[l] : 0;
        int right = isEven? piles[r] : 0;

        dp[l][r] = Math.max(dfs(piles, l+1, r) + left, dfs(piles, l, r-1) + right);

        return dp[l][r];  
    }
}