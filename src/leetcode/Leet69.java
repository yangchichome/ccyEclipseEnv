package leetcode;

public class Leet69 {

}
class Solution {
    public int mySqrt(int x) {
        if (x < 0) return -1;
        else if( x <= 1) return x;

        int start = 1;
        int end = x;

        while (start+1 < end){
            int mid = end + (start - end)/2;
            if (mid == x/mid) return mid;
            else if (mid > x/mid) end = mid;
            else start = mid;
        }

        if (end > x/end) return start;
        else return end; 
    }
}