package leetcode;

public class leet77 {

}
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> partial = new ArrayList<>();

        dfs(n, 1, k, partial, result);

        return result;

    }

    private void dfs(int n, int startIndex, int target, List<Integer> partial, List<List<Integer>> result){
        if (target == 0){
            result.add(new ArrayList<Integer>(partial));
            return;
        }

        for(int i=startIndex; i<=n; i++){

            partial.add(i);
            dfs(n, i+1, target-1, partial, result);
            partial.remove(partial.size() - 1);
        }
    }
}