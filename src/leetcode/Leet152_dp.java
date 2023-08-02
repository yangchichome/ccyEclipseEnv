package leetcode;

public class Leet152_dp {

}
class Solution {
    public int maxProduct(int[] nums) {
        int premax = nums[0], premin = nums[0];
        int result = nums[0]; 
        for(int i=1; i<nums.length; i++){
            int max = Math.max(nums[i], Math.max(premax*nums[i], premin*nums[i]));
            int min = Math.min(nums[i], Math.min(premax*nums[i], premin*nums[i]));

            premax = max;
            premin = min;

            result = Math.max(max, result);
        }

        return result;
    }
}