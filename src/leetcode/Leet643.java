package leetcode;

public class Leet643 {

}
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = k-1;
        while (end < nums.length){
            int sum = 0;
            for (int i=start; i<=end; i++){
                sum += nums[i];
            }
            max = Math.max(max,sum);
            start++;
            end++;
        }

        return (double)max/k;
    }
}