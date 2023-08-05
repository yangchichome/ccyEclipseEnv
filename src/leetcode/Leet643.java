package leetcode;

public class Leet643 {

}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        double maxAvg = 0.0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            // System.out.println("i "+i);
            sum += nums[i];
            if (i < k-1){
                continue;
            }else if (i >= k){
                sum -= nums[i-k];
            }
            maxSum = Math.max(maxSum, sum);
            // System.out.println("sum:"+sum+" ,maxSum:"+maxSum);
        }

        return (double) maxSum/k;
    }
}