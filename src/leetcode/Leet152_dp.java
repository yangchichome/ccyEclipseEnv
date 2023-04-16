package leetcode;

public class Leet152_dp {

}
class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int premax = nums[0], premin = nums[0];
        int max = nums[0], min = nums[0];
        int result = nums[0];

        for (int i=1; i<n; i++){
            max = Math.max(nums[i], Math.max(premax*nums[i], premin*nums[i]));
            min = Math.min(nums[i], Math.min(premax*nums[i], premin*nums[i]));

            premax = max;
            premin = min;

            result = Math.max(max, result);
        }

        return result;
    }
}