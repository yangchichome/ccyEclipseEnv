package lintcode;

public final class Lint123_DFS {

}
public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board.length == 0 || board[0].length == 0) return false;
        if (word.length() == 0) return true;

        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean res = dfs(board,word, i , j, 0);
                    if (res) 
                        return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int start){
        if (start == word.length()) return true;

        int n = board.length;
        int m = board[0].length;

        if (i >= n || i < 0 || j >= m || j < 0 || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#';
        boolean result = dfs(board,word,i+1,j,start+1) 
        || dfs(board,word,i-1,j,start+1) 
        || dfs(board,word,i,j+1,start+1)
        || dfs(board,word,i,j-1,start+1);

        board[i][j] = word.charAt(start);

        return result;
    }
}