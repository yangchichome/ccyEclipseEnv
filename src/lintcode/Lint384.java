package lintcode;

public class Lint384 {

}
public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here

        int[] indexL = new int[128];
        Arrays.fill(indexL, -1);
        int result = 0;
        for(int l=0, r=0; r<s.length(); r++){
            l = Math.max(l, indexL[s.charAt(r)] + 1);
            result = Math.max(result,r-l+1);
            indexL[s.charAt(r)] = r;
        }

        return result;
    }
}