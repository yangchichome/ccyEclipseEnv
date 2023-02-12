package leetcode;

public class ClassicalBinarySearch {

    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int findPosition(int[] nums, int target) {
        // write your code here
        if(nums==null || nums.length==0) return -1;

        int start = 0;
        int end = nums.length-1;
        while (start+1 < end){
            int mid = start + (end-start)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (nums[start]!=target && nums[end]!=target) return -1;
        if (nums[start]==target) return start;
        else return end;

    }
}