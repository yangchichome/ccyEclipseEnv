package leetcode;

public class Leet643 {

}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i=0; i<k; i++){
            sum += nums[i];
        }
        int max = sum;
        int start = 0;
        for(int i=k; i<nums.length; i++){
            sum += nums[i];
            sum -= nums[start++];

            max = Math.max(sum, max);
        }

        return (double) max/k;
    }
}