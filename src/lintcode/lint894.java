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
        if (array == null || array.length == 0) return;

        int n = array.length;
        for (int i=n-1; i>=0; i--){
            int max = 0;
            for (int j=0; j<=i; j++){
                if (array[j] > array[max]){
                    max = j;
                }
            }

            if (max == 0){
                flip(array, i);
            }else {
                flip(array, max);
                flip(array, i);
            }
        }
    }

    private void flip(int[] array, int p){
        int s = 0;
        int e = p;
        while(s < p){
            int tmp = array[s];
            array[s] = array[e];
            array[e] = tmp;
            s++;
            e--;
        }
    }
}