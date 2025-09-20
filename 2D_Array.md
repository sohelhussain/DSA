# 1. print ractengel

#### output
```
👇 i
* * * * *  -> j
* * * * *   
* * * * *
* * * * *
```
code
```
        int n = 4;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++) {
                System.out.print("* ");          <- this print one row
            }
            System.out.println();        <- this is for moving cursor into next line
        }
```
---
# 2. print left tringle

#### output
```
* 
* * 
* * * 
* * * * 
```
code
```
        int n = 4;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");          <- this print one row
            }
            System.out.println();        <- this is for moving cursor into next line
        }
```
---
# 3. print down left tringle

#### output
```
* * * * 
* * * 
* * 
* 
```
code
```
        int n = 4;
        for(int i = n; i >= 1; i++){
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");          <- this print one row
            }
            System.out.println();        <- this is for moving cursor into next line
        }
```
---
# 4. print mirror tringle

#### output
```
*        |         *
* *      |       * *
* * *    |     * * *
* * * *  |   * * * *


0 0 0 *   <- fill with zero
0 0 * *
0 * * *
* * * *
```
code
```
        int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){     <- this is for row
                System.out.print("0 ");
            }
            for(int j = 1; j <= i; j++) {     <- this also row
                System.out.print("* ");
            }
            System.out.println();
        }
```
---
# 5. print tringle

#### output
```
    *
 * * * *
* * * * * 
```
code
```
        int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");    
            }
            for(int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
```
---
# 6. print V

Hint: j jnha se start he or jnha par khtam he vnha ki printing karni he
#### output
```
👇 j start
* 0 0 *  <- j end  <- only print this
 * 0 *
  * *
   *
```
code
```
        int n = 5;
        for(int i = n; i >= 1; i--){
            // System.out.println(i);
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
```

---
# 7. print X

#### output
```
*   *
  *
*   *
```
code
```
        int n = 5;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if (i == j || i + j == n + 1) {
                    System.out.print("* ");
                }else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
```
---
# 8. Rotate Image [solve here](https://leetcode.com/problems/rotate-image/)

```
class Solution {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
```
---
# 9. Search a 2D Matrix [solve here](https://leetcode.com/problems/search-a-2d-matrix/)

```
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] nums: matrix) {
            for(int num: nums) {
                if(num == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
[solve in O(log(m + n))]()
---

# . Valid Sudoku [solve here](https://leetcode.com/problems/valid-sudoku/)
```
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
```
or 
```
class Solution {
     public boolean rowCheck(char[] row) {
        Set<Character> set = new HashSet<>();
        for (char c : row) {
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                }
                set.add(c);
            }
        }
        return true;
    }

    public boolean columnCheck(char[][] board, int j) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i][j] != '.') {
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }

    public boolean subSudukoCheck(char[][] board, int i, int j) {
        Set<Character> set = new HashSet<>();
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                char c = board[k][l];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (!rowCheck(board[i])) {
                return false;
            }
            if (!columnCheck(board, i)) {
                return false;
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board[i].length; j += 3) {
                if (!subSudukoCheck(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
```
---
# 51. N-Queens [solve here](https://leetcode.com/problems/n-queens/description/)
1. backtrack
```
class Solution {
    private boolean isValid(int[][] board, int row, int column) {
        int i = row, j = column;

        while(i >= 0 && j >= 0) {
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }


        i = row;
        j = column;

        while(j >= 0) {
            if(board[i][j] == 1) return false;
            j--;
        }

        i = row;
        j = column;

        while(i < board.length && j >= 0) {
            if(board[i][j] == 1) return false;
            i++;
            j--;
        }

        return true;
    }
    private void nqueens(int[][] board, List<List<String>> ans, int column, int n) {
        if(column == n) {
            List<String> cur = new ArrayList<>();
            for(int row[]: board) {
                String r = "";
                for(int data: row) {
                    r += data == 1 ? "Q" : "."; 
                }
                cur.add(r);
            }
            ans.add(cur);
            return;
        }
        for(int row = 0; row < n; row++) {
            if(isValid(board, row, column)) {
                board[row][column] = 1;
                nqueens(board, ans, column + 1, n);
                board[row][column] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        nqueens(board, ans, 0, n);
        return ans;
    }
}
```

![IMG_0072](https://github.com/user-attachments/assets/4d3bb712-2f9c-4538-89bf-a323b823ae41)

---
# 37. Sudoku Solver [solve here](https://leetcode.com/problems/sudoku-solver/)
1. backtrack
```
class Solution {
    private boolean isValid(char[][] board, int row, int column, char k) {
        for (int var = 0; var < 9; var++) {
            if (board[row][var] == k || board[var][column] == k) {
                return false;
            }
            if (board[3 * (row / 3) + var / 3][3 * (column / 3) + var % 3] == k) {
                return false;
            }
        }
        return true;
    }

    public boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}

```

---

# 79. Word Search [solve here](https://leetcode.com/problems/word-search/)
1. backtrack
```
class Solution {
    private boolean exist(char[][] board, String word, int[][] visited, int row, int col, int ind, int m, int n) {
        if(ind == word.length()) {
            return true;
        }
        if(row < 0 || row >= m || col < 0 || col >= n || visited[row][col] == 1 || board[row][col] != word.charAt(ind)) {
            return false;
        }

        visited[row][col] = 1;
        int[] cc = {-1, 0, 1, 0};
        int[] cr = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++) {
            int nRow = row + cr[i];
            int nCol = col + cc[i];
            if(exist(board, word, visited, nRow, nCol, ind + 1, m, n)) {
                return true;
            }
        }

        // if(exist(board, word, visited, row - 1, col, ind + 1, m, n)
        // || exist(board, word, visited, row, col + 1, ind + 1, m, n)
        // || exist(board, word, visited, row + 1, col, ind + 1, m, n)
        // || exist(board, word, visited, row, col - 1, ind + 1, m, n)) {
        //     return true;
        // }

        visited[row][col] = 0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int visited[][] = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(exist(board, word, visited, i, j, 0, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
