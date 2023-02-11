package leetcode;

public class Longest_Palindrome_S1 {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        int[] charStatArray = new int[52];
        int evenChars=0;
        int oddChars=0;
        for (char c : s.toCharArray()){
            if (c >=97){
                charStatArray[26+c-'a']++;
            }else{
                charStatArray[c-'A']++;
            }
        } 
        for (int n : charStatArray){
            if (n % 2 == 0){
                evenChars+= n;
            }
            else{
                if (n==1){
                    oddChars++;
                }
                else{
                    oddChars++;
                    evenChars+= n-1;
                }
            }
        }
    return oddChars > 0 ? evenChars+1 :evenChars;
    }
}