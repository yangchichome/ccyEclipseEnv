package leetcode;

public class leet40 {

}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partial = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, partial, result);

        return result;
    }

    private void dfs(int[] arr, int startIdx, int target, List<Integer> partial, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<Integer>(partial));
            return;
        }
        if (target < 0){
            return;
        }

        for(int i=startIdx; i<arr.length; i++){
            if (i>startIdx && arr[i] == arr[i-1]){
                continue;
            }
            int targetNew = target - arr[i];

            if (targetNew < 0){
                break;
            }
            partial.add(arr[i]);
            dfs(arr, i+1, targetNew, partial, result);
            partial.remove(partial.size()-1);
        }
    }
}