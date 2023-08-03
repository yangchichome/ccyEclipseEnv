package lintcode;

public class Lint641 {

}
public class Solution {
    /**
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (nums.length == 0){
            updateAns((long)lower-1, (long)upper+1, result);
            return result;
        }
        for(int i=0; i<nums.length; i++){
            if (i == 0){
                updateAns((long)lower-1, (long)nums[i], result);
            }
            if (i == nums.length-1){
                updateAns((long)nums[i], (long)upper+1, result);
                break;
            }
            updateAns((long)nums[i], (long)nums[i+1], result);
        }

        return result;
    }

    private void updateAns(long s, long e, List<String> result){
        if (Math.abs(s-e) < 2) return;
        
        StringBuilder sb = new StringBuilder();
        long start = s+1;
        long end = e-1;
        sb.append(start);
        if (start != end){
            sb.append("->");
            sb.append(end);
        }    
        
        result.add(sb.toString());
    }
}