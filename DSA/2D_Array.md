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

Hint: j jnha se start he or jnha par khtam he vnha ki printing karni he
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
