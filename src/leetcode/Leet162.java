package leetcode;

public class Leet162 {

}
class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int start = 0;
        int end = nums.length - 1;
        while(start+1 < end){
            int mid = start + (end-start)/2;
            // System.out.println("mid:"+mid+" s:"+start+" e:"+end);
            if (nums[mid] < nums[mid-1]){
                end = mid-1;
                // System.out.println("    mid:"+mid+" s:"+start+" e:"+end);
            }else if (nums[mid] < nums[mid+1]){
                start = mid+1;
                // System.out.println("    mid:"+mid+" s:"+start+" e:"+end);
            }else{
                // System.out.println("    mid:"+mid+" s:"+start+" e:"+end);
                return mid;
            }
        } 

        return nums[start] > nums[end] ? start:end;
    }
}