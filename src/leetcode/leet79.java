package leetcode;

public class leet79 {

}
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0){
            return false;
        }
        if (word.length() == 0) return true;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean res = dfs(board, word, i ,j, 0);

                    if (res){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start){
        if (start == word.length()){
            return true;
        }
        
        int n = board.length;
        int m = board[0].length;
        if (i<0 || i>=n || j<0 || j>=m || word.charAt(start) != board[i][j]){
            return false;
        }

        board[i][j] = '#';
        boolean res = dfs(board, word, i+1, j, start+1) ||
            dfs(board, word, i, j+1, start+1) ||
            dfs(board, word, i-1, j, start+1) ||
            dfs(board, word, i, j-1, start+1);
        board[i][j] = word.charAt(start);
        return res;        

    }
}