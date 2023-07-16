package leetcode;

public class leet5 {

}
class Solution {
    public String longestPalindrome(String s) {


        String result = "";
        int maxlen = 0;
        for (int i=0; i<s.length(); i++){
            int len1 = getlen(s, i, i);
            int len2 = getlen(s, i, i+1);

            if (len1 > maxlen || len2 > maxlen){
                maxlen = Math.max(len1, len2);
                if (maxlen == len1){
                    int lenhalf = maxlen/2;
                    result = s.substring(i-lenhalf, i+lenhalf+1);
                }else{
                    int lenhalf = maxlen/2 - 1;
                    result = s.substring(i-lenhalf, i+lenhalf+2);
                }
            }
        }

        return result;
    }

    private int getlen(String s, int l, int r){
        int count = l == r? -1 : 0; 
        while(l >= 0 && r < s.length()){
            if (s.charAt(l) == s.charAt(r)){
                count += 2;
                l--;
                r++;
            }else{
                break;
            }
        }
        return count;

    }
}