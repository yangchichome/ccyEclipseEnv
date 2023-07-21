package leetcode;

public class leet200_BFS {

}
class coordinate {
    int x;
    int y;
    public coordinate (int x, int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (grid[i][j] == '1'){
                    count++;
                    // System.out.println("x:"+i+" ,y:"+j+", c:"+count);
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }
    private void bfs(char[][] grid, int i, int j){
        Stack<coordinate> stack = new Stack<>();

        stack.push(new coordinate(i, j));
        int[] delx = new int[]{0,0,1,-1};
        int[] dely = new int[]{1,-1,0,0};

        while(!stack.isEmpty()){
            coordinate C = stack.pop();
            int x = C.x;
            int y = C.y;
            // System.out.println("    bfs-start"+"x:"+x+" ,y:"+y);
            grid[x][y] = 'V';

            for(int k=0; k<4; k++){
                int xnew = x + delx[k];
                int ynew = y + dely[k];
                // System.out.println("        bfs-add-stack"+"x:"+xnew+" ,y:"+ynew);
                if (xnew >=0 && xnew < grid.length && ynew >=0 && ynew < grid[0].length && grid[xnew][ynew] == '1'){

                    stack.push(new coordinate(xnew, ynew));
                }
            }
        }
    }
}
