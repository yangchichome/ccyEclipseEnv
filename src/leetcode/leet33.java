package leetcode;

public class leet33 {

}
class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length-1;

        while(l+1 < r){
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            // System.out.println("mid:"+ mid+" ,l:"+l+" ,r: "+r);
            // System.out.println("nums[mid]"+nums[mid]+" ,nums[l]:"+nums[l]+" ,nums[r]"+nums[r]+" ,target:"+target);
            if (nums[mid] < nums[r]){
                if (target <= nums[r] && target >= nums[mid]){
                    // System.out.println("case1");
                    l = mid;
                }else{
                    // System.out.println("case2");
                    r = mid;
                }
            }else{
                if (target >= nums[l] && target <= nums[mid]){
                    // System.out.println("case3");
                    r = mid;
                }else{
                    // System.out.println("case4");
                    l = mid;
                }
            }
        }
        if (nums[r] == target) return r;
        if (nums[l] == target) return l;
        return -1;

    }
}