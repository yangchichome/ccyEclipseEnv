package leetcode;

public class leet53_array {

}
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int x:nums){
            sum += x;
            maxSum = Math.max(sum, maxSum);
            sum = sum>0? sum:0;
        }

        return maxSum;
    }
}