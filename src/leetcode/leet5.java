package leetcode;

public class leet5 {

}
class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int len = s.length();
        int lenmax = 0;
        int start = 0;
        
        for (int i=0; i<len; i++){
            int lencur = Math.max(getlen(s, i, i), getlen(s, i, i+1));

            if (lencur > lenmax){
                lenmax = lencur;
                start = i - (lencur - 1)/2;
            }
        }

        return s.substring(start, start + lenmax);
    }

    private int getlen(String s, int start, int end){
        while(start >= 0 && end < s.length()){
            if (s.charAt(start) == s.charAt(end)){
                start--;
                end++;
            } else{
                break;
            }
        }
        return end - start - 1;
    }
}