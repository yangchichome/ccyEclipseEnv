package lintcode;

public class Lint52 {

    /**
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int len = nums.length;
        if (len <= 1) return nums;
        int i = len-1;
        while (i > 0 && nums[i] <= nums[i-1]) i--;
        
        swapList(nums,i,len-1);

        if (i != 0) {
            int j = i;
            while (nums[i-1] >= nums[j]) j++;
            swap(nums,i-1,j);
        }

        return nums;

    }

    public void swapList(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
    public void swap(int[] nums,int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}