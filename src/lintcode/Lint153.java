package lintcode;

public class Lint153 {

    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     *          we will sort your return value in output
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0){
            return result;
        }
        
        Arrays.sort(num);
        List<Integer> combination = new ArrayList<>();
        helper(num,0, combination,target,result);

        return result;
    }

    public void helper(int[] num,int startIndex,List<Integer> combination,int target,List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }      
        for (int i=startIndex ; i < num.length; i++){
            if (i != startIndex && num[i] == num[i-1]){
                continue;
            }
            if (target < num[i]) break;
            combination.add(num[i]);
            helper(num,i+1,combination,target - num[i],result);
            combination.remove(combination.size() - 1);
        }
    }
}