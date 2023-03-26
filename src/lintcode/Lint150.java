package lintcode;

public class Lint150 {

}
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        int profits = 0;
        for(int i=1; i< prices.length; i++){
            int profit = prices[i] - prices[i-1];
            if(profit > 0){
                profits += profit;
            }
        }

        return profits;
    }
}