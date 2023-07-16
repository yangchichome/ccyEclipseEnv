package leetcode;

public class leet34 {

}
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }

        int[] result = new int[2];
        int l = 0;
        int r = nums.length-1;
        while(l+1 < r){
            int m = l + (r-l)/2;
            if (nums[m] >= target){
                r = m;
            }else{
                l = m;
            }
        }        
        
        
        if (nums[r] != target && nums[l] != target){
            return new int[]{-1, -1};
        }
        result[0] = nums[l] == target? l:r;
        l = result[0];
        r = nums.length-1;
        while(l+1 < r){
            int m = l + (r-l)/2;
            if (nums[m] <= target){
                l = m;
            }else{
                r = m;
            }
        }  

        result[1] = nums[r] == target? r:l;

        return result;
    }
}