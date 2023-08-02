package leetcode;

public class leet350 {

}
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x:nums1){
            if (map.containsKey(x)){
                map.put(x, map.get(x)+1);
            }else{
                map.put(x, 1);
            }
        }
        List<Integer> tmp = new ArrayList<>();
        for(int x: nums2){
            if (map.containsKey(x) && map.get(x) > 0){
                map.put(x, map.get(x)-1);
                tmp.add(x);
            }
        }
        int[] result = new int[tmp.size()];
        for(int i=0; i<tmp.size(); i++){
            result[i] = tmp.get(i);
        }

        return result;

    }
}