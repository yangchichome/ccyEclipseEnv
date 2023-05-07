package leetcode;

public class leet75 {

}
class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int s = 0;
        int e = len-1;
        int p = 0;

        while(p <= e) {
            if (nums[p] == 0){
                swap(nums, p, s);
                p++;
                s++;
            }else if (nums[p] == 2){
                swap(nums, p, e);
                e--;
            }else{
                p++;
            }
        } 
    }

    public void swap(int[] nums, int s, int e){
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}