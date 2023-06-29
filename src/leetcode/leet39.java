package leetcode;

public class leet39 {

}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) return result;

        List<Integer> partial = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(candidates, 0, target, partial, result);

        return result;
    }

    private void dfs(int[] candidates, int startIndex, int target, List<Integer> partial, List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<Integer>(partial));
            return;
        }

        for (int i=startIndex; i<candidates.length; i++){

            if (candidates[i] > target){
                break;
            }
            partial.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], partial, result);
            partial.remove(partial.size()-1);

        }
    }
}