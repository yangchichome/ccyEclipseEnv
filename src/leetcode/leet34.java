package leetcode;

public class leet34 {

}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = {-1, -1};
        int s = 0;
        int e = nums.length-1;

        if (nums == null || nums.length == 0) return ans;

        while(s+1 < e){
            int m = s +(e-s)/2;
            if (nums[m] >= target) {
                e = m;
            }else {
                s = m;
            }
        }

        if (nums[s] != target && nums[e] != target) {
            return ans;
        }else if (nums[s] == target){
            ans[0] = s;
        }else{
            ans[0] = e;
        }
        
        s = 0;
        e = nums.length-1;

        while(s+1 < e){
            int m = s +(e-s)/2;
            if (nums[m] <= target) {
                s = m ;
            }else {
                e = m;
            }
        }

        if (nums[s] != target && nums[e] != target) {
            return ans;
        }else if (nums[e] == target){
            ans[1] = e;
        }else{
            ans[1] = s;
        }

        return ans;

    }
}