package leetcode;

public class leet153 {

}
class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int start = 0;
        int end = n-1;

        while (start+1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                return nums[mid];
            }else if (nums[mid] > nums[end]){
                start = mid;
            }else{
                end = mid;
            }
        }

        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}