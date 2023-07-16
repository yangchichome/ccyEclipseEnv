package leetcode;

public class Leet162 {

}
class Solution {
    public int findPeakElement(int[] nums) {
        
        int l = 0;
        int r = nums.length-1;

        while (l+1 < r){
            int mid = l +(r-l)/2;
            if (nums[mid] < nums[mid+1]){
                l = mid;
            }else if (nums[mid] < nums[mid-1]){
                r = mid;
            }else{
                return mid;
            }
        }

        return nums[l]<nums[r] ? r : l;
    }
}