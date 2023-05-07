package leetcode;

public class leet200_BFS {

}
class Coordinate {
    int x = 0;
    int y = 0;
    public Coordinate (int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
     

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        // boolean[][] visited = new boolean[m][n];

        int count = 0; 
        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (grid[i][j] == '1'){
                    bfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    public void bfs (char[][] grid, int i, int j){
        Queue<Coordinate> queue = new LinkedList<>();
        int[] xShift = {-1, 1, 0, 0};
        int[] yShift = {0, 0, 1, -1}; 

        queue.offer(new Coordinate(i, j));
        while (!queue.isEmpty()){
            Coordinate coor = queue.poll();
            int x = coor.x;
            int y = coor.y;
            // System.out.println("x:"+x+" y:"+y);
            char c = grid[x][y];

            grid[x][y] = '0';
            for (int k=0; k<4; k++){
                int xnew = x + xShift[k];
                int ynew = y + yShift[k];
                if (xnew < 0 || xnew > grid.length-1 || ynew < 0 || ynew > grid[0].length-1){
                    continue;
                }
                if (grid[xnew][ynew] == '1'){
                    grid[xnew][ynew] = '0';
                    queue.offer(new Coordinate(xnew, ynew));
                }
            }
        } 
    }
}

