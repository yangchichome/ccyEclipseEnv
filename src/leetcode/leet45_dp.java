package leetcode;

public class leet45_dp {

}
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if (dp[j] != Integer.MAX_VALUE && nums[j]+j >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }

        return dp[n-1];
        
    }
}