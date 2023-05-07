package leetcode;

public class leet1 {

}
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int len = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i=0; i<len; i++){
            int tmp = target - nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}