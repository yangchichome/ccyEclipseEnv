package leetcode;

public class leet40 {

}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0 ){
            return result;
        }
        List<Integer> partial = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(candidates, 0, target, partial, result);
        return result;
    }

    private void dfs(int[] candidates, int startIndex, int target, List<Integer> partial, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<Integer>(partial));
            return;
        }

        for (int i=startIndex; i<candidates.length; i++){
            if (i != startIndex && candidates[i] == candidates[i-1]){
                continue;
            }

            if (target < candidates[i]){
                break;
            }

            partial.add(candidates[i]);
            dfs(candidates, i+1, target-candidates[i], partial, result);
            partial.remove(partial.size()-1);
        }
    }

}