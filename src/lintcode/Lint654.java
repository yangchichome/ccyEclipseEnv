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
        int[][] result = new int[n][m];
        int len = a[0].length;

        for (int r=0;r<n;r++)
            for (int c=0;c<m;c++)
                for (int k=0;k<len;k++)
                    result[r][c] += a[r][k]*b[k][c];

        return result;
    }
}