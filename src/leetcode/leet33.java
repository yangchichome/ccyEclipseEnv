package leetcode;

public class leet33 {

}
class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        if (target < nums[s] && target>nums[e]) return -1;

        while(s+1 < e){
            int m = s + (e-s)/2;
            if (nums[s] == target ) return s;
            if (nums[e] == target ) return e;
            if (nums[m] == target ) return m;

            if (nums[s] < nums[e]){
                if(nums[m] > target) {
                    e = m;
                }else if(nums[m] < target){
                    s = m;
                }       
            }else{
                if (nums[m] > nums[s]){
                    if (target > nums[s] && target < nums[m]){
                        e = m;
                    }else {
                        s = m;
                    }
                }else{
                    if (target < nums[e] && target > nums[m]){
                        s = m;
                    }else{
                        e = m;
                    }
                }
            }
        }

        if (nums[s] == target){
            return s;
        } else if (nums[e] == target){
            return e;
        }

        return -1;
    }
}