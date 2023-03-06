package lintcode;

public class Lint18 {

    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     *          we will sort your return value in output
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }

        Arrays.sort(nums);
        List<Integer> subset = new ArrayList<>();
        helper(nums,subset,0,result);

        return result;
    }
    public void helper(int[] nums,List<Integer> subset,int start,List<List<Integer>> result){
        result.add(new ArrayList<Integer>(subset));
        for (int i=start;i<nums.length;i++){
            if (i != start && nums[i] == nums[i-1]) continue;
            subset.add(nums[i]);
            helper(nums,subset,i+1,result);
            subset.remove(subset.size()-1);
        }
    }
}