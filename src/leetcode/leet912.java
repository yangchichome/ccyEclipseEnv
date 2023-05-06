package leetcode;

public class leet912 {

}
class Solution {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quicksort(nums, 0 ,len-1);

        return nums;
    }

    private void quicksort(int[] nums, int s, int e){
        if (s >= e) return;

        int mid = s + (e - s)/2;
        int left = s;
        int right = e;  
        int pivot = nums[mid];
    
        while (left <= right) {
            while (left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right]= tmp;
                left++;
                right--;
            }
        }
        quicksort(nums, s, right);
        quicksort(nums, left, e);
    }
}