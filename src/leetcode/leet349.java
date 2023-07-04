package leetcode;

public class leet349 {

}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null){
            return new int[0];
        }

        HashSet<Integer> set1 = new HashSet<>();
        for (int x: nums1){
            if (!set1.contains(x)){
                set1.add(x);
            }
        }

        HashSet<Integer> result = new HashSet<>();
        for(int x: nums2){
            if (set1.contains(x) && !result.contains(x)){
                result.add(x);
            }
        }

        int[] ans = new int[result.size()];

        int i = 0;
        for (Integer x: result){
            ans[i++] = x;
        }

        return ans;
            
    }
}