package leetcode;

public class leet22 {

}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(n, 0, 0, sb, result);

        return result;
    }

    private void dfs(int n, int L, int R, StringBuilder sb, List<String> result){
        if (L == n && R == n){
            result.add(sb.toString());
        }

        if (L < n){
            sb.append("(");
            dfs(n, L+1, R, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }

        if (R < n && R < L){
            sb.append(")");
            dfs(n, L, R+1, sb, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}