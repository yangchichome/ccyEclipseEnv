package leetcode;

public class leet31 {

}
class Solution {
    public void nextPermutation(int[] nums) {

        if (nums.length <= 1) return;

        int n = nums.length;
        int i = n-1;
        while (i>0 && nums[i] <= nums[i-1]){
            i--;
        }

        swapList(nums, i, n-1);

        if (i != 0){
            int j = i;
            while (nums[j] <= nums[i-1]){
                j++;
            }
            swap(nums, i-1, j);
        }
    }

    private void swapList(int[] nums, int i, int j){
        while (i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}