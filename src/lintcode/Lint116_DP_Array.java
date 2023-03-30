package lintcode;

public class Lint116_DP_Array {

}
public class Solution {
    /**
     * @param a: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] a) {
        // write your code here
        boolean[] dp = new boolean[a.length];
        dp[0] = true;

        for(int i=1; i<a.length; i++){
            for(int j=0; j<i; j++){
                if (dp[j] && j + a[j] >= i ){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[a.length-1];
    }
}