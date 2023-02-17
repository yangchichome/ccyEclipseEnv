package lintcode;

public class PancakeSorting894 {

    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        // Write your code here
        for (int i=array.length-1;i>0;i--){
            
            int Max = 0;
            for (int j=0;j <= i;j++){
                if (array[Max] < array[j]){
                    Max = j;
                }
            }
            if (Max != 0 && Max != i) {
                FlipTool.flip(array,Max);
                FlipTool.flip(array,i);
            }else if (Max == 0){
                FlipTool.flip(array,i);
            }
        }
    }
}