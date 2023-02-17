package leetcode;

public class SortColors148 {

    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0){
            return;
        }

        int end = colorSort(nums,0,nums.length-1,2);
        int end2 = colorSort(nums,0,end,1);

    }

    public int colorSort(int[] nums,int left, int right,int color){
        while (left <= right ){
            while (left <= right && nums[left] != color){
                left++;
            }
            while (left <= right && nums[right] == color){
                right--;
            }
            if (left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }

        return right;
    }
}