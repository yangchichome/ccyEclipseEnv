package leetcode;

public class leet74 {

}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int sizem = matrix.length;
        int sizen = matrix[0].length;

        int l = 0;
        int r = sizem-1;
        while(l+1 < r){
            int m = l+(r-l)/2;
            if (matrix[m][0] > target){
                r = m;
            }else if (matrix[m][0] < target){
                l = m;
            }else{
                return true;
            }
        }
        int idxR = 0;
        if (matrix[r][0] <= target){
            idxR = r;
        }else {
            idxR = l;
        }

        l = 0;
        r = sizen-1;

        while(l+1 < r){
            int m = l+(r-l)/2;
            if (matrix[idxR][m] > target){
                r = m;
            }else if (matrix[idxR][m] < target){
                l = m;
            }else{
                return true;
            }
        } 

        if (matrix[idxR][l] == target){
            return true;
        }else if (matrix[idxR][r] == target){
            return true;
        }

        return false;
    }
}