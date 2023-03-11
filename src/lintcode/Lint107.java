package lintcode;

public class Lint107 {

    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        // write your code here
        if (s == null) return true;

        int maxLength = 0;
        for(String sub:wordSet){
            maxLength = Math.max(maxLength,sub.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i=1;i <= n;i++){
            for (int j=1;j <= maxLength;j++){
                if (i>j) break;
                if (!dp[i-j]) continue;
                String word = s.substring(i-j,i);
                if (wordSet.contains(word)){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}