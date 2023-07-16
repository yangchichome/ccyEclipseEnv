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
        if (l == null || l.length == 0) return 0;
        // len max.L[]  --> 1 P
        // len 114      --> 7 p
        // len ?        --> k p
        // len 1        --> Sum.L[] p
        // getPieces(int len)

        long s = 0;
        long e = 0;
        for(int w:l){
            e += w;
        }

        while(s+1 < e){
            long m = s +(e-s)/2;
            long pieces = getPieces(l, m);
            // System.out.println("s:"+s+", e:"+e+", m:"+m+", p"+pieces);
            if (pieces >= k){
                s = m;
            }else if (pieces < k){
                e = m;
            }
        }
        return (int)s;

    }

    private long getPieces(int[] woods, long lenFinal){
        long pieces = 0;
        for(int woodLen: woods){
            pieces += woodLen/lenFinal;
        }

        return pieces;
    }
}