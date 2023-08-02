package leetcode;

public class leet122 {

}
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i=1; i<prices.length; i++){
            int delta = prices[i] - prices[i-1];
            sum += delta>0? delta:0;
        }
        return sum;
    }
}