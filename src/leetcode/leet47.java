package leetcode;

public class leet47 {

}
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;

        List<Integer> partial = new ArrayList<>();
        int n = nums.length;
        boolean[] isVisited = new boolean[n+1];
        Arrays.sort(nums);

        dfs(nums, isVisited, partial, result);

        return result;
    }

    private void dfs(int[] nums, boolean[] isVisited, List<Integer> partial, List<List<Integer>> result){

        if (partial.size() == nums.length){
            result.add(new ArrayList<Integer>(partial));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if (isVisited[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]){
                continue;
            }

            partial.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, isVisited, partial, result);
            isVisited[i] = false;
            partial.remove(partial.size() - 1);
        }
    }
}