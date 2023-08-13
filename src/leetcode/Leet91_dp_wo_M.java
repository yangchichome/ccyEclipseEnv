package leetcode;

public class Leet91_dp_wo_M {

}
class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1; 

        for(int i=1; i<=n; i++){
            
            int d1 = s.charAt(i-1) - '0';
            if(d1 != 0){
                dp[i] = dp[i-1];
            }
            
            if(i>1){
                int d2 = Integer.valueOf(s.substring(i-2,i));
                if(d2 >= 10 && d2 <= 26){
                    dp[i] += dp[i-2];
                }
            }
        }

        return dp[n];
    }
}