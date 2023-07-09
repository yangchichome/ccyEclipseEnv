package leetcode;

public class leet3 {

}
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];
        char[] ca = s.toCharArray();
        int max = 0;
        for(int l=0, r=0; r<ca.length; r++){
            map[ca[r]]++;
            while(map[ca[r]] > 1){
                map[ca[l]]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
        }

        return max;
    }
}