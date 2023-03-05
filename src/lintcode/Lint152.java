package lintcode;
//152 · Combinations
public class Lint152 {

    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     *          we will sort your return value in output
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();

        helper(result,combination,n,k,1);

        return result;
    }

    public void helper(List<List<Integer>> result,List<Integer> combination, int n,int k,int start){
        if (combination.size() == k){
            result.add(new ArrayList(combination));
            return;
        }

        for (int i=start;i <= n;i++){
            combination.add(i);

            helper(result,combination,n,k,i+1);
            combination.remove(combination.size()-1);
        }
    }
}