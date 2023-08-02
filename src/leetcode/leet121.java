package leetcode;

public class leet121 {

}
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int x: prices){
            if (x <= min){
                min = x;
                max = x;
            }else{
                max = Math.max(max, x);
            }
            profit = Math.max(profit, max - min);
        }

        return profit;
    }
}