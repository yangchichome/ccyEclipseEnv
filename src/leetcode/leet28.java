package leetcode;

public class leet28 {

}
class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (n < m) return -1;

        for(int i=0; i<n-m+1; i++){
            if (haystack.charAt(i) == needle.charAt(0)){
                for(int j=0; j<m; j++){
                    if (haystack.charAt(i+j) != needle.charAt(j)){
                        break;
                    }else{
                        if (j == m-1) {
                            return i;
                        }
                    }
                }
            }
        }

        return -1;
    }
}