package leetcode;

public class leet139_DP {

}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if (s.length() == 0) return true;
        int maxLength = 0;
        
        for (String str: wordDict){
            maxLength = Math.max(maxLength, str.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i=1; i<=n; i++){
            for(int l=1; l<=maxLength; l++){
                if (i < l){
                    break;
                }
                if (!dp[i-l]){
                    continue;
                }

                String subStr = s.substring(i-l, i);
                if (wordDict.contains(subStr)){
                    dp[i] = true;
                }
            }
        }

        return dp[n];

    }
}