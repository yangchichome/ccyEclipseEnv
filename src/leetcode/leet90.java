package leetcode;

public class leet90 {

}
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partial = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, partial, result);        

        return result;
    }

    private void dfs(int[] arr, int startIdx, List<Integer> partial, List<List<Integer>> result){
        result.add(new ArrayList<>(partial));
        for(int i=startIdx; i<arr.length; i++){
            if (i > startIdx && arr[i] == arr[i-1]){
                continue;
            }
            partial.add(arr[i]);
            dfs(arr, i+1, partial, result);
            partial.remove(partial.size()-1);
        }
    }
}