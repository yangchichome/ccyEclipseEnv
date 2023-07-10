package leetcode;

public class leet130_bfs {

}
class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if (n <= 1 || m <= 1){
            return;
        }

        for(int i=0; i<n; i++){
            bfs(board, i, 0);
            bfs(board, i, m-1);
        }

        for(int i=0; i<m; i++){
            bfs(board, 0, i);
            bfs(board, n-1, i);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else{
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void bfs(char[][] board, int i, int j){
        if (board[i][j] != 'O') return;

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(i);
        qy.offer(j);
        board[i][j] = 'M';
        while(!qx.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            for (int c=0; c<4; c++){
                int xf = x + dx[c];
                int yf = y + dy[c];

                if (xf >= 0 && xf < board.length && yf >= 0 && yf < board[0].length && board[xf][yf] == 'O'){
                    board[xf][yf] = 'M';
                    qx.offer(xf);
                    qy.offer(yf);
                }
            }
        }
    }
}