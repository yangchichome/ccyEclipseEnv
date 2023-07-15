package lintcode;

public class lint553 {

}
public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }        
        int n = grid.length;
        int m = grid[0].length;

        int result = 0;
        int rows = 0;
        int[] cols = new int[m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (j == 0 || grid[i][j-1] == 'W'){
                    rows = 0;
                    for(int k=j; k<m && grid[i][k] != 'W'; k++){
                        if (grid[i][k] == 'E')
                            rows++;
                    }
                }
                if (i == 0 || grid[i-1][j] == 'W'){
                    cols[j] = 0;
                    for(int k=i; k<n && grid[k][j] != 'W'; k++){
                        if (grid[k][j] == 'E'){
                            cols[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0'){
                    result = Math.max(result, rows + cols[j]);
                }
            }
        }
        return result;
    }
}