package leetcode;

public class leet53_array {

}
class Solution {
    public int maxSubArray(int[] nums) {
        int e = 0;
        int sum = 0;
        int max = nums[0];
        while(e < nums.length){
            sum += nums[e];
            if (sum < nums[e]){
                sum = nums[e];
            }
            max = Math.max(sum, max);
            e++;
        }
        return max;
    }
}