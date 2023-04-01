package lintcode;

public class Lint401_BS {

}
class ResultType {
    public int num;
    public boolean exists;
    public ResultType(int num, boolean exists){
        this.num = num;
        this.exists = exists;
    }
}

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int n = matrix.length;
        int m = matrix[0].length;
        int min = matrix[0][0];
        int max = matrix[n-1][m-1];

        while (min != max) {
            int mid = min + (max - min)/2;
            ResultType result = kthSmellest(matrix,mid);
            if (result.num == k && result.exists){
                return mid;
            }else if (result.num < k){
                min = mid+1;
            }else{
                max = mid;
            }
        }

        return min;
    }

    public ResultType kthSmellest(int[][] matrix, int mid){

        int n = matrix.length;
        int m = matrix[0].length;

        int count = 0;
        int row = 0;
        boolean exist = false;
        int colume = m - 1;

        while(row < n && colume >= 0){
            if (matrix[row][colume] == mid){
                exist = true;
            }
            if (matrix[row][colume] <= mid){
                count += colume + 1;
                row++;
            }else{
                colume--;
            }
        }

        return new ResultType(count,exist);
    }
}