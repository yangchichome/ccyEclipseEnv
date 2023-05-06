package leetcode;

public class leet167 {

}
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) return new int[0];

        int s = 0;
        int e = numbers.length-1;

        while (s <= e){
            if (numbers[s]+numbers[e] > target) {
                e--;
            }else if (numbers[s]+numbers[e] < target){
                s++;
            }else{
                return new int[]{s+1, e+1};
            }
        } 

        return new int[0];
    }
}