package leetcode;

public class Leet215_QS {

}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return -1;

        return partition(nums,0,nums.length-1, nums.length - k);
    }

    private int partition(int[] nums, int left, int right, int k){
        if (left >= right) return nums[k];

        int lo = left, hi = right;
        int pivot = nums[lo + (hi - lo)/2];

        while (lo <= hi) {
            while (lo <= hi && nums[lo] < pivot){
                lo++;
            }
            while (lo <= hi && nums[hi] > pivot){
                hi--;
            }
            if (lo <= hi){
                swap(nums, lo, hi);
                lo++;
                hi--;
            }
        }

        if (k >= lo){
            return partition(nums, lo, right, k);
        }
        if (k <= hi){
            return partition(nums, left, hi, k);
        }

        return nums[k];
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}