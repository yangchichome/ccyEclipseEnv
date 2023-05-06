package leetcode;

public class Leet69 {

}
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int s = 1;
        int e = x;

        while (s+1 < e) {
            int m = s + (e-s)/2;
            if (m > x/m) {
                e = m;
            }else {
                s = m;
            }
        }

        if (e > x/e) return s;
        else return e;

    }
}