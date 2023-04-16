package leetcode;

public class leet300_dp {

}
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];
        int len = 1;
        int maxlen = 1;
        
        for (int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if (nums[j] < nums[i])
                    dp[i] = dp[i] > dp[j]+1 ? dp[i]:dp[j]+1;
            }

            if(dp[i] > maxlen){
                maxlen = dp[i];
            }
        }
        return maxlen;
    }
}