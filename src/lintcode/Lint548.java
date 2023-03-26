package lintcode;

public class Lint548 {

}
public class Solution {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     *          we will sort your return value in output
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
       
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x: nums1){
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }


        List<Integer> result0 = new ArrayList<>();
        for (int x: nums2){
            if (map.containsKey(x)){
                if (map.get(x) > 0) {
                    result0.add(x);
                    map.put(x,map.get(x) - 1);
                }
            }
        }

        int[] result = new int[result0.size()];
        for(int k=0; k<result0.size(); k++){

            result[k] = result0.get(k);
        }
        
        return result;
    }
