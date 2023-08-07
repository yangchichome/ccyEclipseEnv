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
        if (l.length == 0) return 0;
        //len   :   numbers
        //max   :   1
        //<?    :   k-1
        //=?    :   k
        //>?    :   k+1
        //1     :   num.sum

        int lens = 0;
        int lene = 0;
        for(int x: l){
            if (lene < x){
                lene = x;
            }
        }

        //  k-1 < k < k+1
        while(lens+1 < lene){
            int lenm = lens + (lene-lens)/2;
            int mNum = getNumBylen(l, lenm);
            if (mNum >= k) {
                lens = lenm;
            }else{
                lene = lenm;
            }
        }
        if (getNumBylen(l, lene) == k) return lene;
        return lens;
    }
    private int getNumBylen(int[] nums, int len){
        int count = 0;
        for(int x: nums){
            count += x/len;
        }
        return count;
    }
}