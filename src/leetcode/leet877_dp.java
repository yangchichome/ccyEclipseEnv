package leetcode;

public class leet877_dp {

}
class Solution {
    private int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];

        int result = dfs(piles, 0, piles.length-1);
        int sum = 0;
        for(int x: piles){
            sum += x;
        }

        return result > sum/2;
    }

    private int dfs(int[] nums, int s, int e){
        if (s>e){
            return 0;
        }
        if (dp[s][e] != 0) return dp[s][e];

        // int count = 0;
        boolean isEven = (e-s)%2 == 0? true:false;
        int firstP = 0;
        int finalP = 0;
        if(isEven){
            firstP += nums[s];
            finalP += nums[e];
        }

        firstP += dfs(nums, s+1, e);
        finalP += dfs(nums, s, e-1);
        dp[s][e] = Math.max(firstP, finalP);

        return dp[s][e];
    }
}