package leetcode;

public class leet300_dp {

}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
        }

        int maxlen = dp[0];
        for(int i=0; i<n; i++){
            // System.out.println(i+" :"+dp[i]);
            if (dp[i] > maxlen){
                maxlen = dp[i];
            }
        }
        return maxlen;
    }
}