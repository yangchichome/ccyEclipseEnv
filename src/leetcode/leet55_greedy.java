package leetcode;

public class leet55_greedy {

}
class Solution {
    public boolean canJump(int[] nums) {
        int maxjump = nums[0];
        for(int i=1; i<nums.length; i++){
            if (maxjump >= i && i+nums[i] > maxjump){
                maxjump = i + nums[i];
            }
        }

        return maxjump >= nums.length-1;
    }
}