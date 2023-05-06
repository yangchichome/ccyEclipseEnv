package leetcode;

public class leet704 {

}
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int s = 0;
        int e = nums.length-1;

        while(s+1 < e){
            int m = s + (e-s)/2;
            if (nums[m] > target) {
                e = m;
            }else if (nums[m] < target){
                s = m ;
            }else{
                return m;
            }
        }

        if (nums[s] == target) {
            return s;
        }else if (nums[e] == target) {
            return e;
        }else{
            return -1;
        }
    }
}