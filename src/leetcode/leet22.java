package leetcode;

public class leet22 {

}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;

        dfs(n, n, "", result);

        return result;
    }

    private void dfs(int left, int right, String partial, List<String> result){
        if (left == 0 && right == 0){
            result.add(partial);
        }

        if (left > 0){
            dfs(left-1, right, partial+"(", result);
        }
        if (right > 0 && left < right){
            dfs(left, right-1, partial+")", result);
        }
    }
}