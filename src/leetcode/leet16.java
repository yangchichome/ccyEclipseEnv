package leetcode;

public class leet16 {

}
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int ans = nums[0]+nums[1]+nums[2];
        for(int i=0; i<nums.length; i++){
            int s = i+1;
            int e = nums.length-1;
            while(s<e){
                int sum = nums[i] + nums[s] + nums[e];
                int deltaOld = Math.abs(target - ans);
                int deltaNew = Math.abs(target - sum);
                ans = deltaOld < deltaNew? ans : sum; 
                if (sum > target){
                    e--;
                }else if (sum < target){
                    s++;
                }else{
                    return target;
                }
            }  
        }
        return ans;
    }
}