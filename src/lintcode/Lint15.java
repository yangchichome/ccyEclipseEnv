package lintcode;

public class Lint15 {

    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     *          we will sort your return value in output
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length ==0 || nums==null){
            result.add(new ArrayList<Integer>());
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        ArrayList<Integer> subset = new ArrayList<>();

        dfs(nums,visited,subset,result);

        return result;
    }

    public void dfs(int[] nums, boolean[] visited, ArrayList<Integer> subset, List<List<Integer>> result){
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (visited[i]) continue;
            
            subset.add(nums[i]);
            visited[i] = true;
            dfs(nums,visited,subset,result);
            subset.remove(subset.size()-1);
            visited[i] = false;
        }
    }
}