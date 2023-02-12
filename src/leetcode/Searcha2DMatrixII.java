package leetcode;

public class Searcha2DMatrixII {

    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        
        if (matrix==null || matrix.length==0) return 0;
        if (matrix[0]==null || matrix[0].length == 0) return 0;

        int n = matrix.length;
        int m = matrix[0].length;

        int row = n - 1;
        int col = 0;

        int count = 0;

        while(row >= 0 && col < m){
            if (matrix[row][col] > target) {
                row--;
            }else if (matrix[row][col] < target) {
                col++;
            }else{
                count++;
                row--;
                col++;
            }
        }

        return count;
        
    }
}