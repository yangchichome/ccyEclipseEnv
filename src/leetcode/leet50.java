package leetcode;

public class leet50 {

}
class Solution {
    public double myPow(double x, int n) {
        boolean isNegative =false;
        if (n < 0){
            x = 1/x;
            isNegative = true;
            n = -(n+1); 
        }
        
        double tmp = x, result = 1;

        while(n >= 1){
            if(n%2 == 1) {
                result *= tmp;
            }
            tmp *= tmp;
            n = n/2;
        }

        if (isNegative){
            result *= x;
        }

        return result;
    }
}