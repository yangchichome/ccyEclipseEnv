package leetcode;

public class leet50 {

}
class Solution {
    public double myPow(double x, int n) {
        
        boolean isNegative = false;
        if(n < 0) {
            isNegative = true;
            n = -n;
        }
       

        double ans = 1, tmp = x;
        while(n != 0){
            if(n % 2 == 1){
                ans *= tmp;
            }
            tmp *= tmp;
 
            n /= 2;
        }

        return isNegative ? 1/ans : ans;
    }
}