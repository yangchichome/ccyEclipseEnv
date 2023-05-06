package leetcode;

public class Leet29 {

}
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

        if (divisor == -1 ){
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }     

        if (dividend == 0) return 0;   

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int ans = 0;

        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)){
                shift++;
            }

            a -= b << (shift-1);
            ans += 1 << (shift-1);
        } 
         
        return isNegative ? -ans : ans;
    }
}