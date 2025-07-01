class Solution {

    

    //36. Valid Sudoku
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] != '.'){
                    if(!set.add(board[i][j] + "found at" + i + "row")
                    || !set.add(board[i][j] + "found at" + j + "column")
                    || !set.add(board[i][j] + "found at" + (i/3) + "-" + (j/3) + "block")
                    ) return false;
                }
            }
        }
        return true;
    }
}
