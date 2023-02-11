package leetcode;

public class Last_Position_of_Target {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length ==0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        while (left+1 < right) {
            int mid = right + (left-right)/2;
            if (nums[mid] == target){
                left = mid;
            }else if (nums[mid] < target) {
                left = mid;
            }else{
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }else if (nums[left] == target) {
            return left;
        }

        return -1;
    }
}