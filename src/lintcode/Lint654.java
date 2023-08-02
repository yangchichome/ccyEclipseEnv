package lintcode;

public class Lint654 {

}
public class Solution {
    /**
     * @param a: a sparse matrix
     * @param b: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] a, int[][] b) {
        // write your code here
        int n = a.length;
        int m = b[0].length;
        int[][] ans = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<a[0].length; k++){
                    ans[i][j] += a[i][k]*b[k][j]; 
                }
            }
        }

        return ans;
    }
}