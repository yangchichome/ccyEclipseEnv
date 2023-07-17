package leetcode;

public class leet611 {

}
class Solution {
    public int triangleNumber(int[] nums) {
        //triangle a+b > c

        Arrays.sort(nums);
        int count = 0;
        int mulc = 0;
        for(int c=nums.length-1; c>1; c--){
            int s = 0;
            int e = c-1;
            while(s<e){

                int sum = nums[s]+nums[e];
                if (sum > nums[c]){
                    
                    count += e - s;
                    e--;
                }else{
                    
                    s++;
                }
            }
        }
        return count;
    }
}