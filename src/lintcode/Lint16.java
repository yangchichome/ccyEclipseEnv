package lintcode;

public class Lint16 {

    /**
     * @param nums: A list of integers
     * @return: A list of unique permutations
     *          we will sort your return value in output
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0 || nums == null){
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];    
        ArrayList<Integer> subset = new ArrayList<>();
        helper(nums, visited,subset,result);
        return result;
    }

    public void helper(int[] nums,boolean[] visited,ArrayList<Integer> subset, List<List<Integer>> result){
        if (nums.length == subset.size()){
            result.add(new ArrayList<Integer>(subset));
            return;
        }

        for (int i=0;i < nums.length;i++){
            if (visited[i]) continue;
            if (i>0 && nums[i] == nums[i-1] && visited[i-1]) continue;

            subset.add(nums[i]);
            visited[i] = true;
            helper(nums,visited,subset,result);
            visited[i] = false;
            subset.remove(subset.size()-1);

        }
    }
}