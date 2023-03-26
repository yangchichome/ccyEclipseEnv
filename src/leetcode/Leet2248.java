package leetcode;

public class Leet2248 {

}
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1001];
        for(int[] row: nums){
            for(int val: row){
                count[val]++ ;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<count.length; i++){
            if(count[i] == nums.length){
                result.add(i);
            }
        }

        return result;
    }
}