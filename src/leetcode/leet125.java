package leetcode;

public class leet125 {

}
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            while(start < s.length() -1 && !Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start))){
                start++;
            }
            while(end >=0 && !Character.isLetter(s.charAt(end)) && !Character.isDigit(s.charAt(end))){
                end--;
            }
            if (start < end){
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }
}