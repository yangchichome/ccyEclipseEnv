package leetcode;

public class leet209 {

}
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1;
        int sum = 0;
        for(int l=0,r=0; r<nums.length; r++){
            sum += nums[r];
            while(sum >= target){
                min = Math.min(min, r-l+1);
                sum -= nums[l];
                l++;
            }
        }

        return min == nums.length+1? 0:min;
    }
}