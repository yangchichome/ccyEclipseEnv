package leetcode;

public class Leet198_dp_rolling {

}
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[3];

        dp[0] = 0;
        dp[1] = nums[0];
        for (int i=2; i<=n; i++){
            dp[i%3] = Math.max(dp[(i-1)%3], dp[(i-2)%3] + nums[i-1]);
        }

        return dp[n%3];
    }
}