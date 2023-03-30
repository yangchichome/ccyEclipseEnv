package lintcode;

public class Lint603 {

}
public class Solution {
    /**
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        if (nums.length == 0 || nums == null) return new ArrayList<>();

        HashMap<Integer,Integer> dp = new HashMap<>();
        HashMap<Integer,Integer> prev = new HashMap<>();

        Arrays.sort(nums);

        int n = nums.length;
        for(int i=0; i<n; i++){
            dp.put(nums[i],1);
            prev.put(nums[i],-1);
        }

        int lastNum = nums[0];
        for (int i=0; i<n; i++){
            int num = nums[i];
            for(int factor: getFactor(num)){
                if(!dp.containsKey(factor)){
                    continue;
                }
                if(dp.get(num) < dp.get(factor) + 1){
                    dp.put(num,dp.get(factor)+1);
                    prev.put(num,factor);
                }
            }
            if(dp.get(num) > dp.get(lastNum)){
                lastNum = num;
            }
        }

        return getPath(prev,lastNum);
    }

    public List<Integer> getFactor(int num){
        List<Integer> factors = new ArrayList<>();
        if (num == 1) return factors;

        int factor = 1;
        while(factor * factor <= num){
            if (num % factor == 0){
                factors.add(factor);
                if (factor !=1 && num / factor != factor){
                    factors.add(num / factor);
                }
            }
            factor++;
        }
        return factors;
    }

    public List<Integer> getPath(HashMap<Integer,Integer> prev, int lastNum){
        List<Integer> path = new ArrayList<>();
        while(lastNum != -1){
            path.add(lastNum);
            lastNum = prev.get(lastNum);
        }
        Collections.reverse(path);
        return path;        
    }
}