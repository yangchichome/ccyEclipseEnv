package leetcode;

public class Sqrtx {

    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if (x==0) return 0;
        else if (x<0) return -1;

        int start = 1;
        int end = x; 

        while (start+1 < end){
            int mid = start +(end-start)/2;
            
            if (mid == x/mid) {
                return mid;
            }else if (mid > x/mid){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (end < x/end) return end;
        else return start;

    }
}