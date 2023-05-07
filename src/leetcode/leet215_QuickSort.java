package leetcode;

public class leet215_QuickSort {

}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        int len = nums.length;
        return quickSort(nums, 0, len-1, len - k);
    }

    private int quickSort(int[] nums, int start, int end, int k){
        if (start >= end) return nums[k];

        int s = start;
        int e = end;
        int m = s + (e-s)/2;
        int pivot = nums[m];

        while (s <= e){
            while (s <= e && nums[s] < pivot){
                s++;
            }
            while (s <= e && nums[e] > pivot){
                e--;
            }
            if (s <= e) {
                int tmp = nums[s];
                nums[s] = nums[e];
                nums[e] = tmp;
                s++;
                e--;
            }
        }

        if (e >= k){
            return quickSort(nums, start, e, k);
        }else if (s <= k) {
            return quickSort(nums, s, end, k);
        }

        return nums[k];
    }
}