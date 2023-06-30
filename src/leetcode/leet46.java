package leetcode;

public class leet46 {

}
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) return result;
        
        List<Integer> partial = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length+1];

        dfs(nums, isVisited, partial, result);
        return result;
    }

    private void dfs(int[] nums, boolean[] isVisited, List<Integer> partial, List<List<Integer>> result){
        if (nums.length == partial.size()){
            result.add(new ArrayList<Integer>(partial));
            return;
        }

        for (int i=0; i<nums.length; i++){
            if(isVisited[i]){
                continue;
            }

            partial.add(nums[i]);
            isVisited[i] = true;
            dfs(nums, isVisited, partial, result);
            isVisited[i] = false;
            partial.remove(partial.size()-1);
        }
    }
}