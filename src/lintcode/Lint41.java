package lintcode;

public class Lint41 {

}
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE,sum = 0;
        for (int i = 0;i<nums.length;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            sum = Math.max(sum,0);
        }

        return max;
    }
}