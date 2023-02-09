package leedcode;

public class Longest_Palindrome_Dynamic_Programming {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s.length()==0) return "";
        
        int n = s.length();
        boolean[][] is_palindrome = new boolean[n][n];

        for (int i=0;i<n;i++){
            is_palindrome[i][i] = true;
        }
        for (int i=1;i<n;i++){
            is_palindrome[i][i-1] = true;
        }

        int start = 0;
        int longest = 1;

        for (int length=2;length < n+1;length++){
            for (int i=0;i<n - length + 1;i++){
                int j = i + length -1;
                is_palindrome[i][j] = is_palindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if (is_palindrome[i][j] && length > longest){
                    longest = length;
                    start = i;
                }
            }
        }

        return s.substring(start, start+longest);
    }

}
