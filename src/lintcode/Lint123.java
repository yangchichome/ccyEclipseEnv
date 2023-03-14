package lintcode;

public class Lint123 {

    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if (board == null || board.length == 0) return false;
        if (word.length() == 0) return true;


        for (int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (board[i][j] == word.charAt(0)) {
                    boolean result = find(board,word,i,j,0);
                    if (result) return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board,String word,int i,int j,int start){
        if (start == word.length()) return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start) ) return false;

        board[i][j] = '#';
        boolean res = find(board,word,i+1,j,start+1) || find(board,word,i-1,j,start+1) || find(board,word,i,j+1,start+1) || find(board,word,i,j-1,start+1);
        board[i][j] = word.charAt(start);

        return res;
    }
}