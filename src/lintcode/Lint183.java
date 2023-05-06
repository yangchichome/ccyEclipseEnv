package lintcode;

public class Lint183 {

}
public class Solution {
    /**
     * @param l: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] l, int k) {
        // write your code here
        // len = 1      , pieces = l.sum;
        // len = k      , pieces = ?;
        // len = l.max  , pieces = 1;
        // len > l.max  , pieces = 0;
        int maxL = 0;
        for (int i=0; i< l.length; i++){
            maxL = Math.max(l[i], maxL);
        }

        int s = 0;
        int e = maxL;

        while (s+1 < e){
            int m = s + (e-s)/2;

            if (isKpossible(l, k, m)) {
                s = m;
            }else{
                e = m;
            }
        }

        return isKpossible(l, k, e)? e : s;
    }

    public boolean isKpossible(int[] w,int k, int len) {
        int pieces = 0;

        for (int i=0; i<w.length; i++){
            pieces += w[i]/len;
        }

        return pieces >= k ? true : false;
    } 
}