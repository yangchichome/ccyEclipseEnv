package leetcode;

public class leet75 {

}
class Solution {
    public void sortColors(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int idx = 0;
        while(s<=e){
            if(nums[s] == 2){
                swap(nums, s, e);
                e--;
            }else if (nums[s] == 0){
                swap(nums, s, idx);
                idx++;
                s++;                
            }else{
                s++;
            }
        }
    
    }

    private void swap(int[] nums, int s, int e){
        int tmp = nums[s];
        nums[s] = nums[e];
        nums[e] = tmp;
    }
}