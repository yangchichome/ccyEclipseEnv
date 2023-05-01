package leetcode;

public class leet125 {

}
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        
        int n = s.length();
        int start = 0;
        int end = n-1;
        while (start < end) {
            while (start < n && !isValid(s.charAt(start))){
                start++;
            }

            if (start == n){
                return true;
            }

            while (end >= 0 && !isValid(s.charAt(end))){
                end--;
            }

            if (Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))) {
                start++;
                end--;
            }else {
                return false;
            }
        }

        return true;
    }
    public boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    } 
}