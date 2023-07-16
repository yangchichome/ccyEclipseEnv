package leetcode;

public class Leet409 {

}
class Solution {
    public int longestPalindrome(String s) {
        int[] chars = new int[52];

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i) - 'a';
            if (index < 0){
                index = s.charAt(i) - 'A' + 26;
            }
            chars[index]++;
        }

        int count = 0;
        boolean isodd = false;
        for(int c: chars){
            if (c%2 == 1){
                isodd = true;
                count += c-1;
            }else{
                count += c;
            }
        }
        
        return isodd? count+1 : count;
        
    }
}