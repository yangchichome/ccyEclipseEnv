package leetcode;

public class leet45_dp {

}
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

         Arrays.fill(dp, n);
//        for(int i=0; i<n; i++){
//            dp[i] = n;
//        }
        dp[0] = 0;
        for(int i=0; i<n; i++){
            int jump = nums[i];
            for(int j=i; j<=i+jump && j<n; j++){
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }

        return dp[n-1];
    }
}