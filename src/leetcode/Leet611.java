package leetcode;

public class Leet611 {

}
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        Arrays.sort(nums);
        int result = 0;

        for (int c=n-1; c>=2; c--){
            int lo = 0;
            int hi = c-1;
            while (lo < hi) {
                if (nums[c] < nums[lo] + nums[hi]){
                    result += hi - lo;
                    hi--;
                }else{
                    lo++;
                }                
            }
        }
        return result;
    }
}