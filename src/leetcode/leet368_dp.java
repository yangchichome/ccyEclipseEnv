package leetcode;

public class leet368_dp {

}
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0){
            return ans;
        }

        Arrays.sort(nums);
        
        int[] dp = new int[n];
        int[] prev = new int[n];
        for(int i=0; i<n; i++){
            dp[i] = 1;
            prev[i] = i;
            for(int j=0; j<i; j++){
                if(nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            } 
        }

        int max = 0;
        int max_i = 0;
        for(int i=0; i<n; i++){
            if (dp[i] > max){
                max = dp[i];
                max_i = i;
            }
        }

        ans.add(nums[max_i]);

        while(max_i != prev[max_i]){
            max_i = prev[max_i];
            ans.add(nums[max_i]);
        }

        Collections.reverse(ans);
        return ans;
    }
}