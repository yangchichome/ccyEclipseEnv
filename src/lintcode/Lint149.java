package lintcode;

public class Lint149 {

}
public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here

        if (prices.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices){
            min = price > min ? min : price;
            profit = (price - min) > profit ? (price - min) : profit;
        }

        return profit;
    }
}