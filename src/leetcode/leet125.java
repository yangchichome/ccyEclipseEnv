package leetcode;

public class leet125 {

}
class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length()-1;

        
        while (l < r){

            while (l < s.length() && !isValid(s.charAt(l))){
                l++;
            }
            if (l == s.length()){
                return true;
            }

            while (r >= 0 && !isValid(s.charAt(r))){
                r--;
            }

            if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))){
                l++;
                r--;
            }else{
                return false;
            } 
        }
        return true;
    }

    private boolean isValid(char c){
        return Character.isDigit(c) || Character.isLetter(c);
    }
}