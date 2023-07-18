package lintcode;

public class lint894 {

}
public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        // Write your code here
        for(int i=array.length-1; i>=0; i--){
            // printArr(array, i); 
            int maxi = getMax(array, i+1);
            // System.out.println("    maxi: "+maxi);
            FlipTool.flip(array, maxi);
            FlipTool.flip(array, i);
        }
    }

    private int getMax(int[] nums, int size){
        int maxi = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<size; i++){
            if(nums[i] > max){
                max = nums[i];
                maxi = i;
            }
        }
        return maxi;
    }
}