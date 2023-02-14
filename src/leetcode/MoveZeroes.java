package leetcode;

public class MoveZeroes {

    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        int left = 0, right = 0;
        while(right < nums.length){
            if (nums[right]!=0){
                if (left != right){
                    nums[left] = nums[right];
                }
                left++;
            }
            right++;
        }

        while(left < nums.length){
            if (nums[left] != 0){
                nums[left] = 0;
            }
            left++;
        }
    }
}