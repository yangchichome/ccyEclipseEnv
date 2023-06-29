package leetcode;

public class leet90 {

}
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Arrays.sort(nums);

        List<Integer> partial = new ArrayList<>();

        dfs(nums, 0, partial, result);

        return result;
    }

    private void dfs(int[] nums, int startIndex, List<Integer> partial, List<List<Integer>> result){

        result.add(new ArrayList<Integer>(partial));

        for(int i=startIndex; i<nums.length; i++){
            if (i != startIndex && nums[i] == nums[i-1]){
                continue;
            }

            partial.add(nums[i]);
            dfs(nums, i+1, partial, result);
            partial.remove(partial.size() - 1);
        }
    }
}