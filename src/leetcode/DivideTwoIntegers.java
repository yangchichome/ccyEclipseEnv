package leetcode;

public class DivideTwoIntegers {

    /**
     * @param dividend: the dividend
     * @param divisor: the divisor
     * @return: the result
     */
    public int divide(int dividend, int divisor) {
        // write your code here
        if (divisor == 0){
            return dividend >=0 ? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        if (dividend == 0){
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        boolean isNegative = ( dividend < 0 && divisor > 0 ) || ( dividend > 0 && divisor < 0 );

        int ans = 0;
        long divA = Math.abs((long)dividend);
        long divB = Math.abs((long)divisor);

        while (divA >= divB ){
            int shift = 1;
            while (divA >= divB << shift){
                shift++;
            }
            divA -= divB << (shift - 1);
            ans += 1 << (shift -1);
        }

        return isNegative ? -1*ans : ans;

    }
}