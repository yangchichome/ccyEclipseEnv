package leetcode;

public class leet128 {

}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int v : nums){
            set.add(v);
        }   

        int ans = 0;
        for (int v : nums){
            if (set.contains(v)){
                set.remove(v);
            
                int left = v-1;
                int right = v+1;

                while(set.contains(left)){
                    set.remove(left);
                    left--;
                }
                while(set.contains(right)){
                    set.remove(right);
                    right++;
                }

                ans = Math.max(ans,right - left - 1);
            }
        }

        return ans;

    }
}