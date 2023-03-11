package lintcode;

public class Lint427 {

    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     *          we will sort your return value in output
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (n <= 0){
            return result;
        }
        helper(result,n,n,"");

        return result;
    }

    public void helper(List<String> result,int left,int right,String Subset){
        if (left == 0 && right ==0 ){
            result.add(Subset);
            return;
        }
        if (left > 0) {
            helper(result,left-1,right,Subset+"(");
        }
        if (right > 0 && left < right){
            helper(result,left,right-1,Subset+")");
        }
    }
}