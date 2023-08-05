package leetcode;

public class Leet674 {

}
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int count = 1;
        int maxlen = 1;
        for(int i=1; i<nums.length; i++){
            if (nums[i] > nums[i-1]){
                count++;
            }else{
                count = 1;
            }
            maxlen = Math.max(maxlen, count);
        }

        return maxlen;
    }
}