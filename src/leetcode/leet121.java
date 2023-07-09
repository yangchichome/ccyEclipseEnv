package leetcode;

public class leet121 {

}
class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxP = 0;
        for (int price: prices){
            if (price < min){
                min = price;
            }else{
                maxP = Math.max(maxP, price - min);
            }
        }

        return maxP;   
    }
}