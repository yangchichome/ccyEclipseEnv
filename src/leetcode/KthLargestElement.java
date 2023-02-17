package leetcode;

public class KthLargestElement {

    /**
     * @param k: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums==null || nums.length==0 || k > nums.length || k<1){
            return 0;
        }

        return partition(nums,0,nums.length - 1,nums.length-k);
    }

    public int partition(int[] nums,int start,int end, int k){
        if (start >= end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[(left+right)/2];

        while (left <= right){
            while (left <= right && nums[left] < pivot){
                left++;
            }
            while (left <= right && nums[right] > pivot){
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

        if (k <= right){
            return partition(nums,start,right,k);
        }
        if (k >= left){
            return partition(nums,left,end,k);
        }

        return nums[k];
    }
}