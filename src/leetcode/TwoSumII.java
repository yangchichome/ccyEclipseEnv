package leetcode;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length==0){
            return new int[0];
        }

        int left = 0, right = numbers.length-1;
        
        while(left < right){

            if (numbers[left]+numbers[right] > target){
                right--;
            }else if (numbers[left]+numbers[right] < target){
                left++;
            }else{
                return new int[]{left+1,right+1};
            }

        }

        return new int[0];
    }
}