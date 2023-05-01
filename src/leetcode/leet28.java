package leetcode;

public class leet28 {

}
class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = haystack.length();
        int m = needle.length();
        for (int i=0; i<n-m+1; i++){
            if (needle.charAt(0) == haystack.charAt(i)){
                int count = 1;
                for (int j=1; j<m; j++){
                    if (needle.charAt(j) == haystack.charAt(i+j)){
                        count++;
                    }else{
                        break;
                    }
                }

                if (count == m){
                    return i;
                }
            }
        }

        return -1;
    }
}