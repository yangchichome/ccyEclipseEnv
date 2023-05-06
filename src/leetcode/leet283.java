package leetcode;

public class leet283 {

}
class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length){
            if (nums[fast] != 0) {
                if (nums[fast] != nums[slow]){
                    nums[slow] = nums[fast];
                }
                slow++;
            }
            fast++;
        }

        while (slow < nums.length){
            if (nums[slow] != 0){
                nums[slow] = 0;
            }
            slow++;
        }
    }
}