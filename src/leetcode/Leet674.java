package leetcode;

public class Leet674 {

}
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int length = 1;
        int maxlen = 1;
        for (int i=1; i<n; i++){
            if (nums[i] > nums[i-1]){
                length++;
                maxlen = Math.max(maxlen, length);
            }else{
                length = 1;
            } 
        }
        return maxlen;
    }
}