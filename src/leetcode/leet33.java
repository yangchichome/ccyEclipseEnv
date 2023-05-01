package leetcode;

public class leet33 {

}
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int n = nums.length;
        int s = 0;
        int e = n-1;

        while (s+1 < e){
            int m = s + (e-s)/2;
            if (nums[m] > nums[e]) {
                if (nums[m] >= target && target >= nums[s]) {
                    e = m;
                }else{
                    s = m;
                }
            }else{
                if (nums[m] <= target && target <= nums[e]){
                    s = m;
                }else{
                    e = m;
                }
            }
        }

        if (nums[s] == target) {
            return s;
        }else if (nums[e] == target){
            return e;
        }else{
            return -1;
        }
    }
}