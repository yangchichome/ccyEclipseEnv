package leetcode;

public class Searcha2DMatrix {

    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0){
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0){
            return false;
        }

        int row = matrix.length;
        int colume = matrix[0].length;

        // System.out.println("row:"+row+" colume:"+colume);
        int start = 0;
        int end = row-1;

        // System.out.println("s:"+start+" e:"+end);

        while (start+1 < end){
            int mid = start + (end - start)/2;
            // System.out.println("s:"+start+" e:"+end+" m:"+mid);
            if (matrix[mid][0] == target){ 
                return true;
            }else if (matrix[mid][0] > target){
                end = mid;
            }else{
                start = mid;
            }
        } 

        if (matrix[end][0] <= target){
            row = end;
        }else if(matrix[start][0] <= target){
            row = start;
        }else{
            return false;
        }

        // System.out.println("row "+row);
        start = 0;
        end = colume -1;

        while (start+1 < end){
            int mid = start + (end - start)/2;
            // System.out.println("s:"+start+" e:"+end+" m:"+mid);
            if (matrix[row][mid] == target){
                return true;
            }else if (matrix[row][mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if (matrix[row][start] == target || matrix[row][end] == target){
            return true;
        }else{
            return false;
        }
    }
}