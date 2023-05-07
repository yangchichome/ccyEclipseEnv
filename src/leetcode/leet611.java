package leetcode;

public class leet611 {

}
class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3 ) return 0;

        int len = nums.length;
        Arrays.sort(nums);

        int count = 0;
        for (int i=len-1; i>=0; i--){
            int s = 0;
            int e = i-1;
            while (s < e){
                if (nums[s]+nums[e] > nums[i]){
                    count += e-s;
                    e--;
                }else {
                    s++;
                }
            }
        }

        return count;
    }
}