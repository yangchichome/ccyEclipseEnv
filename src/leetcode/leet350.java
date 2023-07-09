package leetcode;

public class leet350 {

}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {

        int m = nums1.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<m; i++){
            if (map.containsKey(nums1[i])){
                map.put(nums1[i], map.get(nums1[i]) + 1);

            }else{
                map.put(nums1[i], 1);

            }
        }

        int n = nums2.length;
        List<Integer> temp = new ArrayList<>();
        for (int i=0; i<n ; i++){
            int x = nums2[i];
            if (map.containsKey(x) && map.get(x) > 0){
                map.put(x, map.get(x)-1);
                temp.add(x);
            }
        }

        int[] result = new int[temp.size()];
        for (int i=0; i<temp.size(); i++){
            result[i] = temp.get(i);
        }

        return result;
    }
}