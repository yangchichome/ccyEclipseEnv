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
        long left = (long) lower;
        long right = (long) upper;
        int n = nums.length;
        
        List<String> result = new ArrayList<>();
        
        if (n == 0){
            add(result, left-1, right+1);
            return result;
        }

        add(result, left-1, nums[0]);
        for(int i=1; i<n; i++){
            add(result, nums[i-1], nums[i]);
        }
        add(result, nums[n-1], right+1);

        return result;
    }

    private void add(List<String> result, long left, long right){
        if (left == right){
            return;
        }else if (left+1 == right){ 
            return;
        }else if (left+1 == right-1){
            result.add(String.valueOf(left+1));
        }else{
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(left+1));
            sb.append("->");
            sb.append(String.valueOf(right-1));
            result.add(sb.toString());
        }
    }

}