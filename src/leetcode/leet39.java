package leetcode;

public class leet39 {

}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partial = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, partial, result);
        return result;
    }
    private void dfs(int[] arr, int startIdx, int target, List<Integer> partial, List<List<Integer>> result){    
        if (target == 0){
            result.add(new ArrayList<>(partial));
        }

        for(int i=startIdx; i<arr.length; i++){
            int targetNew = target - arr[i];
            if (targetNew < 0){
                break;
            }

            partial.add(arr[i]);
            dfs(arr, i, targetNew, partial, result);
            partial.remove(partial.size()-1);
        }
    }
}