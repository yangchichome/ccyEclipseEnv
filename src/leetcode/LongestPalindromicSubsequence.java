package leetcode;

public class LongestPalindromicSubsequence {

    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        int size = s.length();
        char[] ss = s.toCharArray();

        if (size <= 1){
            return size;
        }
        
        int[][] dp = new int[size][size];
        for (int i=0;i<size;i++){
            dp[i][i] = 1;
        }

        for (int i = size-1;i>=0;i--){
            for (int j=i+1;j<size;j++){
                if (ss[i]==ss[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }

        return dp[0][size-1];

    }
}