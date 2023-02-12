package leetcode;

public class Powxn {

    /**
     * @param x: the base number
     * @param n: the power number
     * @return: the result
     */
    public double myPow(double x, int n) {
        // write your code here
        boolean isNegative = false; 
        
        if (n < 0){
            x = 1/x;
            isNegative = true;
            n = -(n+1);
        }
        double ans = 1.0, tmp = x;
        while (n != 0){
            if (n % 2 ==1){
                ans *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }

        if (isNegative){
            ans *= x;
        }
        return ans;

    }
}