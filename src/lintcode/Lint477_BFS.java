package lintcode;

public class Lint477_BFS {

}
public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board.length <= 1 ||board[0].length <= 1){
            return;
        }

        int n = board.length;
        int m = board[0].length;

        for (int i=0; i<n; i++){
            bfs(board, i, 0);
            bfs(board, i, m-1);
        }

        for(int j=0; j<m; j++){
            bfs(board, 0, j);
            bfs(board, n-1, j);
        }

        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (board[i][j] == 'W'){
                    board[i][j] = 'O';
                } else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int x, int y){
        if (board[x][y] != 'O') return; 
        
        int[] dx = new int[] {-1,0,1,0};
        int[] dy = new int[] {0,-1,0,1};

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(x);
        qy.offer(y);
        board[x][y] = 'W';
        while(!qx.isEmpty()){
            int cx = qx.poll();
            int cy = qy.poll();

            for (int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < board.length && nx >= 0 && ny < board[0].length && ny >= 0 && board[nx][ny] == 'O'){
                    board[nx][ny] = 'W';
                    qx.offer(nx);
                    qy.offer(ny);
                }
            }
        }



    }
}