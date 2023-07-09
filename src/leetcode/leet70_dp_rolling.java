package leetcode;

public class leet70_dp_rolling {

}
class Solution {
    public int climbStairs(int n) {
        if (n <= 2){
            return n;
        }

        int pre1 = 1;
        int pre2 = 1;
        int now  = 0;
        for (int s=2; s<=n; s++){
            now = pre1 + pre2;
            pre2 = pre1;
            pre1 = now;
        }

        return now;
    }
}