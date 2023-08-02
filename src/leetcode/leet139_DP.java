package leetcode;

public class leet139_DP {

}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int m = 0;
        for(String str: wordDict){
            m = Math.max(m, str.length());
        }

        boolean[] dp = new boolean[n+1];
        dp[0] = true; 
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m && j<=i; j++){
                int k = i-j;
                if (!dp[k]){
                    continue;
                }
                String substr = s.substring(k, i);
                if (wordDict.contains(substr)){
                    dp[i] = true;
                }
            }
        }

        return dp[n];
    }
}