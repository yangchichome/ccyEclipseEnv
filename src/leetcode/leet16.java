package leetcode;

public class leet16 {

}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);

        int minDelta = Integer.MAX_VALUE;
        int minSum = 0;
        for (int i=0; i<len; i++){
            int s = i+1;
            int e = len-1;
            while(s < e){
                int sum = nums[s]+nums[e]+nums[i];
                int delta = Math.abs(sum - target);
                if (delta < minDelta){
                    minSum = sum;
                    minDelta = delta;
                }

                if (sum > target){
                    e--;
                }else if (sum < target){
                    s++;
                }else{
                    return target;
                }
            }
        }
        return minSum;
    }
}