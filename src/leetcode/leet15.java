package leetcode;

public class leet15 {

}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;

        Arrays.sort(nums);
        int len = nums.length;

        for (int k=0; k<len; k++){
            if (k > 0 && nums[k] == nums[k-1]){
                continue;
            }

            int target = -nums[k];
            int s = k+1;
            int e = len-1;

            while(s < e){
                if (nums[s] + nums[e] > target){
                    e--;
                }else if (nums[s] + nums[e] < target){
                    s++;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[k]);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    result.add(list);
                    e--;
                    s++;

                    while (s < e && nums[e] == nums[e+1]){
                        e--;
                    }
                    while (s < e && nums[s] == nums[s-1]){
                        s++;
                    }

                }
            }
        }

        return result;
        
    }
}