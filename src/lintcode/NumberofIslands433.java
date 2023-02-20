package lintcode;

class coordinate {
    int x,y;
    public coordinate(int x, int y){
        this.x=x;
        this.y=y;
    }
}

public class NumberofIslands433 {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */

    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null){
            return 0;
        }

        int count = 0;
        
        for (int i=0;i< grid.length;i++){
            for(int j=0;j< grid[0].length;j++){
                if (grid[i][j]){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(boolean[][] grid,int x,int y){
        int[] coorX = {1,-1,0,0};
        int[] coorY = {0,0,1,-1};

        Queue<coordinate> coors = new LinkedList<>();

        coors.offer(new coordinate(x, y));

        grid[x][y] = false;

        while(!coors.isEmpty()){
            coordinate coor = coors.poll();

            for (int i=0;i<coorX.length;i++){
                coordinate adj = new coordinate(coor.x + coorX[i],coor.y + coorY[i]);

                if (isBound(grid,adj)){
                    // System.out.println("x:"+adj.x+" y:"+adj.y);
                    continue;
                }
                if (grid[adj.x][adj.y]){
                    grid[adj.x][adj.y] = false;
                    coors.offer(adj);
                }
            }
        }
    }

    public boolean isBound(boolean[][] grid,coordinate adj){
        if (adj.x >= grid.length || adj.y >= grid[0].length || adj.x < 0 || adj.y < 0){
            return true;
        }

        return false;

    }
}