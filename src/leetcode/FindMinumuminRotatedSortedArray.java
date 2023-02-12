package leetcode;

public class FindMinumuminRotatedSortedArray {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length ==0){
            return -1;
        }

        int start=0;
        int end = nums.length-1;

        while (start+1 < end){
            
            int mid = start + (end-start)/2;

            if (nums[start] < nums[end]){
                return nums[start];
            }
            if (nums[start] > nums[mid]){
                end = mid;
            }else {
                start = mid;
            }
        }

        return Math.min(nums[start],nums[end]);

    }
}