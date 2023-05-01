package leetcode;

public class Leet162 {

}
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;

        int n = nums.length;
        int s = 0;
        int e = n-1;

        while(s+1 < e){
            int m = s + (e - s)/2;
            if (nums[m] < nums[m-1]){
                e = m;
            }else if (nums[m] < nums[m+1]){
                s = m;
            }else{
                return m;
            }
        } 

        return nums[s] > nums[e] ? s : e;
    }
}