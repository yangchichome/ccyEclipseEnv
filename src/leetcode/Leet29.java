package leetcode;

public class Leet29 {

}
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 ) 
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        if (dividend == 0) 
            return 0;

        if (divisor == -1 && dividend == Integer.MIN_VALUE) 
            return Integer.MAX_VALUE;
    
        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long v = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int ans = 0;
        while (v >= d){
            int shift = 0;
            
            while (v >= (d << shift)){
                shift++;
            }

            shift--; 
            v -= d << shift;
            ans += 1 << shift;
        }

        return isNegative ? -ans:ans;
    }
}