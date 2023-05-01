package leetcode;

public class leet5 {

}
class Solution {
    public String longestPalindrome(String s) {
        
        if (s == null || s.length() == 0) return "";
        if (s.length() == 1) return s;

        int n = s.length();
        int maxlen = 0;
        int start = 0;
        for (int i=0; i<n-1; i++){
            
            int temp = Math.max(getlen(s, i, i), getlen(s, i, i+1));
            if (temp > maxlen) {
                maxlen = temp;
                start = i - (temp-1)/2;
            };
        }
        return s.substring(start, start + maxlen);
    }

    public int getlen(String s, int i, int j){

        while (i >=0 && j < s.length()){
            if (s.charAt(i) == s.charAt(j)){
                i--;
                j++;
            }else{
                break;
            }
        }

        return j - i - 1 ;
    }
}