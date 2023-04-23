package leetcode;

public class Leet553 {

}
public class Solution {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return: an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // write your code here
        int m = grid.length;
        int n = m > 0 ? grid[0].length : 0;

        int result = 0, rows = 0;
        int[] cols = new int[n];

        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (j==0 || grid[i][j-1] == 'W'){
                    rows = 0;
                    for(int k=j; k<n && grid[i][k] != 'W'; k++){
                        if (grid[i][k] == 'E'){
                            rows++;
                        }
                    }
                }
                if (i==0 || grid[i-1][j] == 'W'){
                    cols[j] = 0;
                    for(int k=i; k<m && grid[k][j] != 'W'; k++){
                        if (grid[k][j] == 'E')
                            cols[j]++;
                    }
                }

                if(grid[i][j] == '0' && result < cols[j]+rows){
                    result = cols[j] + rows;
                }
            }
        }

        return result;
    }
}