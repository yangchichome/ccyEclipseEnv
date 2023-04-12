package leetcode;

public class Leet53 {

}
class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] dp = new int[2];
        int old = 0;
        int now = 0;
        int result = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++){
            old = now;
            now = 1 - now;
            dp[now] = dp[old] > 0 ? dp[old]+nums[i] : nums[i];
            result = Math.max(result,dp[now]);
        }

        return result;
    }
}