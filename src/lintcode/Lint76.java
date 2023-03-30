package lintcode;

public class Lint76 {

}
public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int n = nums.length;

        int[] dp = new int[n];

        for (int i=n-1; i>-1; i--){
            dp[i] = 1;
            for(int j=i+1; j<n; j++){
                System.out.println("i "+i+"  j "+ j);
                System.out.println("nums[i] "+nums[i]+"  nums[j] "+ nums[j]);
                if (nums[i] < nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        
        int maxSub = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            System.out.println("dp[i]"+dp[i]);
            maxSub = Math.max(maxSub, dp[i]);
        }

        return maxSub;
    }
}