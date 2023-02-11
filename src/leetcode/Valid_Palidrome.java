package leetcode;

public class Valid_Palidrome {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s.length() == 0 || s == null){
            return true;
        }

        int front=0;
        int end = s.length()-1;
        while (front < end) {
            while (front < end && !isValid(s.charAt(front))){
                front++;
            }
            if (front == s.length()){
                return true;
            }
            while (front < end && !isValid(s.charAt(end))){
                end--;
            }
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))){
                break;
            }else{
                front++;
                end--;
            }
        }
        return end <= front;
    }

    public boolean isValid(char c){
        return Character.isLetter(c) || Character.isDigit(c);
    }
}