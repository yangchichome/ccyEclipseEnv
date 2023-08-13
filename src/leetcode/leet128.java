package leetcode;

public class leet128 {

}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x: nums){
            set.add(x);
        }

        int ans = 0;
        for(int x: nums){
            int l = x;
            int r = x;
            while(set.contains(l-1)){
                l--;
                set.remove(l);
            }
            while(set.contains(r+1)){
                r++;
                set.remove(r);
            }
            set.remove(x);
            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}