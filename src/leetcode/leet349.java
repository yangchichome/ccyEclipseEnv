package leetcode;

public class leet349 {

}
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x:nums1){
            if (!map.containsKey(x)){
                map.put(x, 1);
            }
        }
        for(int y:nums2){
            if (map.containsKey(y)){
                map.put(y, 0);
            }
        }
        List<Integer> tmp = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if (entry.getValue() == 0){
                tmp.add(entry.getKey());
            }
        }

        int[] result = new int[tmp.size()];
        for(int i=0; i<tmp.size(); i++){
            result[i] = tmp.get(i);
        }

        return result;

    }
}