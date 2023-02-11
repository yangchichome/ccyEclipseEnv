package leetcode;

public class Longest_Palindrome__Substring_Enumeration {
    /**
     * @param s: input string
     * @return: a string as the longest palindromic substring
     */
    private int start = 0;
    private int longest = 0;
    public String longestPalindrome(String s) {
        // write your code here
        if (s.length()==0) return "";
        
        for (int middle=0;middle<s.length();middle++){
            find_longest_palindrome_from(s,middle,middle);
            find_longest_palindrome_from(s,middle,middle+1);
        }

        return s.substring(start, start+longest);

    }
    public void find_longest_palindrome_from(String s,int left,int right){
        while (left>=0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        if (longest < right -left -1) {
            longest = right -left -1;
            start = left+1;
        }
    }
}
