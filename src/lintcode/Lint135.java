package lintcode;

public class Lint135 {

    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     *          we will sort your return value in output
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        List<Integer> combination = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,combination,0,target,result);

        return result;

    }

    public void helper(int[] candidates,List<Integer> combination, int start,int target, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if (candidates[i] > target) break;
            if (i != 0 && candidates[i] == candidates[i-1]) continue;

            combination.add(candidates[i]);
            helper(candidates,combination,i,target-candidates[i],result);
            combination.remove(combination.size() - 1);
        }

    }
}