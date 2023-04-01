package lintcode;

public class Lint406 {

}
public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) return -1;
        int L = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        for (int R=0; R<nums.length; R++){
            sum += nums[R];

            while (sum >= s){
                ans = Math.min(ans,R-L+1);
                sum -= nums[L];
                L++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}