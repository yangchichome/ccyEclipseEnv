package leetcode;

public class Leet69 {

}
class Solution {
    public int mySqrt(int x) {
        if (x == 0){
            return 0;
        }

        int s = 1;
        int e = x;

        while(s+1< e){
            int m = s + (e-s)/2;
            if(m > x/m){
                e = m;
            }else if (m < x/m){
                s = m;
            }else{
                return m;
            }
        }

        return s;
    }
}