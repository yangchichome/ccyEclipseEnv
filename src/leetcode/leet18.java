package leetcode;

public class leet18 {

}
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 4) return result;

        Arrays.sort(nums);

        int n = nums.length;
        for (int i=0; i<n-3; i++){
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j=i+1; j<n-2; j++){
                if (j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                
                int s = j+1;
                int e = n-1;
                while(s < e){
                    long sum = (long)nums[i]+ (long)nums[j]+ (long)nums[s]+ (long)nums[e];
                    if (sum > target) {
                        e--;
                    }else if (sum < target){
                        s++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[s]);
                        list.add(nums[e]);
                        s++;
                        e--;

                        while (s < e && nums[s] == nums[s-1]){
                            s++;
                        }
                        while (s < e && nums[e] == nums[e+1]){
                            e--;
                        }

                        result.add(list);
                    }
                } 
            }
        }

        return result;
    }
}