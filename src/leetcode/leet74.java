package leetcode;

public class leet74 {

}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int s = 0;
        int e = matrix.length-1;

        while (s+1 < e){
            int m = s + (e-s)/2;
            if (matrix[m][0] == target){
                return true;
            }else if (matrix[m][0] > target){
                e = m;
            }else{
                s = m;
            }
        }

        int i = 0;
        if (matrix[s][0] == target || matrix[e][0] == target) return true;
        if (matrix[e][0] < target) {
            i = e;
        }else{
            i = s;
        }
      
        s = 0;
        e = matrix[0].length-1;

        while (s+1 < e){
            int m = s + (e-s)/2;
            if (matrix[i][m] == target) {
                return true;
            }else if (matrix[i][m] > target){
                e = m;
            }else {
                s = m;
            }
        }

        if (matrix[i][s] == target || matrix[i][e] == target) return true;

        return false;
    }
}