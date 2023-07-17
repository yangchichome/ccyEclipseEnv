package leetcode;

public class leet15 {

}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int s = i+1;
            int e = n-1;
            int target = -nums[i];

            while(s<e){
                List<Integer> temp = new ArrayList<>();
                int sum = nums[s]+nums[e];
                if (sum > target){
                    e--;
                }else if (sum < target){
                    s++;
                }else{
                    temp.add(nums[i]);
                    temp.add(nums[s]);
                    temp.add(nums[e]);
                    result.add(temp);
                    e--;
                    s++;
                    while(e > i && nums[e] == nums[e+1])
                        e--;
                    while(s < n && nums[s] == nums[s-1])
                        s++;
                }
            }
        }


        return result;
    }
}