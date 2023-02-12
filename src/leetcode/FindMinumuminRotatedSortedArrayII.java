package leetcode;

public class FindMinumuminRotatedSortedArrayII {

    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0) return 0;

        int start = 0;
        int end = nums.length-1;
        
        while(start+1 < end){
            int mid = start + (end-start)/2;
            // System.out.println("S:"+start+" E:"+end+" m:"+mid);
            if (nums[start] < nums[end]){
                return nums[start];
            }
            if (nums[start] > nums[mid]){
                end = mid;
            }else if (nums[start] < nums[mid]){
                start = mid;
            }else{
                start += 1; 
            }
        }

        return nums[start] < nums[end] ? nums[start] : nums[end]; 
    }
}