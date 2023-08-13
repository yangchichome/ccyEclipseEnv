package leetcode;

public class leet120_dp {

}
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        //dp[i][j] = tri[i][j] + min(dp1, dp2)
        //dp[0][0] = tri00, dp[i][i] = dp[i-1][i-1] + tri[i][] ; dp[i][0] = dp[i-1][0] + trii0
        int n = 0;
        for(List<Integer> arr: triangle){
            if (arr.size() > n){
                n = arr.size();
            }
        }

        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1; i<n; i++){
            dp[i][i] = dp[i-1][i-1] + triangle.get(i).get(i);
            // System.out.println("i:"+i+", i:"+i+", dpii:"+dp[i][i]);
            dp[i][0] = dp[i-1][0] + triangle.get(i).get(0);
        }
    
        for(int i=2; i<n; i++){
            for(int j=1; j<i; j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
                // System.out.println("i:"+i+", j:"+j+", dp:"+dp[i][j]+" i-1,j:"+dp[i-1][j]+", i-1,j-1:"+dp[i-1][j-1]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            if (dp[n-1][i] < min){
                min = dp[n-1][i];
            }
        }

        return min;
    }
}