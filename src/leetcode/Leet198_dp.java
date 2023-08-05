package leetcode;

public class Leet198_dp {

}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        int max = 0;
        for(int i=0; i<n; i++){
            if (i == 0){
                dp[i] = nums[0];
            }else if (i == 1){
                dp[i] = Math.max(dp[0], nums[i]);
            }else{
                dp[i] = Math.max(dp[i-2]+nums[i], dp[i-1]);
            }

            max = Math.max(dp[i], max);
        }

        return dp[n-1];
    }
}