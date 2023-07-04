package leetcode;

public class leet53_array {

}
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int x: nums){
            sum += x;
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }
}