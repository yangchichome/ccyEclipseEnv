package leetcode;

public class leet47 {

}
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partial = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];

        Arrays.sort(nums);

        dfs(nums, isVisited, partial, result);

        return result;
    }

    private void dfs(int[] nums, boolean[] isVisited, List<Integer> partial, List<List<Integer>> result){
        if (partial.size() == nums.length){
            result.add(new ArrayList<>(partial));
            return;
        }

        for( int i=0; i<nums.length; i++){
            if (isVisited[i]){
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]){
                continue;
            }
            isVisited[i] = true;
            partial.add(nums[i]);
            dfs(nums, isVisited, partial, result);
            partial.remove(partial.size()-1);
            isVisited[i] = false;
        }
    }
}