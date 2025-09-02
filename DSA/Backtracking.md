# 1. Tower Of Hanoi.

1. First, we move n - 1 plates to the auxiliary rod.
(To do this, we can make the auxiliary rod the temporary destination for a shorter time.)

2. After this, we can move the n-th plate to the destination.


```
public static void towerOfHanoi(int s, int aux, int d, int n){
        if(n==1){
            System.out.println(s + ' -> ' + d);
            return
        }
        //n - 1 plates are gose source to aux.
        towerOfHanoi(s, d, aux, n - 1);
        System.out.println(s + ' -> ' + d);
        towerOfHanoi(aux, s, d, n - 1);
    }

public static void main(String[] args) {
        int n = 3; // plates
        tow(1, 2, 3, n);
    }
```

![towerofhanoi](https://github.com/user-attachments/assets/b91896d3-b2d2-4ae2-b7c0-3fb79d79363d)

---

# 2. Find the Winner of the Circular Game.

1. We create a circular ArrayList and find the index of the person to be eliminated using the formula:
(i + k - 1) % size, where i is the current index, k is the step count, and size is the number of remaining people.

**why we're using this formula** => [Learn more](https://github.com/sohelhussain/DSA/blob/main/why.md#scenario-josephus-problem)

```
class Solution {
    private int alive(List<Integer> people, int i, int k) {
        if(people.size() == 1) return people.get(0);
        int killPerson = (i + k - 1) % people.size();
        people.remove(killPerson);
       return alive(people, killPerson, k);
    }

    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        return alive(list, 0, k);
    }
}

```

![circular array](https://github.com/user-attachments/assets/0c965ea0-f0ca-415d-be8b-b74145e5917c)


---

# 3. Subset powerset **Imp.**


### 1. powerSet
```
class Solution {
public static void subsetString(String s, String cur, List<String> ans, int i) {
    if(i == s.length()) {  // O(1)
        if (cur.length() > 0) {  // O(1)
            ans.add(cur);  // O(n) making a new string
        }
        return;
    }

    //choose
    subsetString(s, cur + s.charAt(i), ans, i + 1); // O(2^n)
    
    // not choose
    subsetString(s, cur, ans, i + 1); // O(2^n)
  } 

    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        subsetString(s, "", ans, 0);
        Collections.sort(ans);
        System.out.println(ans);
    }

}
```

Time Complexity: O(n × 2ⁿ)
Space Complexity: O(n × 2ⁿ)


### 2. 78 subSet [solve here](https://leetcode.com/problems/subsets/)


```
class Solution {
    // Recursive method to generate subsets
    public static void powerKaSetArrayWala(int[] arr, int i, List<Integer> cur, List<List<Integer>> ans) {
        // Base case: If we have processed all elements, add the current subset to the result
        if(i == arr.length) {
            ans.add(new ArrayList<>(cur));  // Add a copy of the current subset
            return;
        }
        
        // Include the current element and move to the next element
        cur.add(arr[i]);
        powerKaSetArrayWala(arr, i+1, cur, ans);
        
        // Backtrack: Remove the last element and move to the next element (not including this one)
        cur.remove(cur.size() - 1);  // Use remove(size - 1) to remove the last element
        
        // Exclude the current element and move to the next element
        powerKaSetArrayWala(arr, i+1, cur, ans);
    }

    // Main function for LeetCode problem
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();  // This will hold all subsets
        List<Integer> cur = new ArrayList<>();  // This is the current subset being built
        
        // Start the recursion
        powerKaSetArrayWala(nums, 0, cur, ans);
        
        return ans;
    }
}
```

#### Time Complexity

we are making a copy that hold O(n)
and we calling a 2^n calls

so final Complexity is ``` O(n * 2^n) ```


### approach 2 

in this time we did'nt call a not pick


```
class Solution {
    private void sets(int[] nums, int start, List<List<Integer>> list, List<Integer> cur) {

        list.add(new ArrayList<>(cur));
        for(int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            sets(nums, i + 1, list, cur);
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        sets(nums, 0, list, cur);
        return list;
    }
}
```

call's look like this.
```
[
  [], 
  [1], 
  [1,2], 
  [1,2,3], 
  [1,3], 
  [2], 
  [2,3], 
  [3]
]
```


![sec-approach](https://github.com/user-attachments/assets/2e1ac177-f0f9-4e6f-bd48-d126e4699de9)

---
# 46. Permutations [solve here](https://leetcode.com/problems/permutations/)

```
class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void permut(int[] nums, List<List<Integer>> list, int start) {
        if(start == nums.length - 1) {
            List<Integer> cur = new ArrayList<>();
            for(int a: nums) cur.add(a);
            list.add(cur);
            return;
        }

        for(int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permut(nums, list, start + 1);
            swap(nums, start, i);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permut(nums, list, 0);
        return list;
    }
}
```
#### Time Complexity ``` n * n!```

![IMG_0058](https://github.com/user-attachments/assets/8d5fc941-437a-47ed-9553-8694779b45fd)


---
# 4. Subsets 2. [solve here](https://leetcode.com/problems/subsets-ii/)

```
class Solution {
    private void setsDup(int[] nums, List<List<Integer>> list, List<Integer> cur, int i, boolean picked) {
        if(i == nums.length) {
            list.add(new ArrayList<>(cur));
            return;
        }
        if(i == 0 || nums[i] != nums[i - 1] || picked) {
            cur.add(nums[i]);
            setsDup(nums, list, cur, i + 1, true);
            cur.remove(cur.size() - 1);
        }
        setsDup(nums, list, cur, i + 1, false);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        setsDup(nums, list, cur, 0, true);
        return list;
    }
}
```
Tree Structure — Step-by-Step
I'll show it as a decision tree where:

✔️ means we pick the element

❌ means we skip it

We'll also show the current cur list at each step.


```
                             []
                         /        \
                    ✔️1             ❌1
                   /   \            \
               ✔️2     ❌2          ✔️2
              /   \     \           \
         ✔️2     ❌2    ✔️2         ❌2
          |       |      |           |
      [1,2,2]  [1,2]   [1,2]       [1]

```
Then on the right side of ❌1, we have:
```
                           []
                             \
                             ✔️2
                            /   \
                        ✔️2     ❌2
                         |        |
                      [2,2]     [2]

```


#### second approach

```
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums); // Corrected the sorting method
        solve(nums, ans, cur, 0);
        return ans;
    }

    public void solve(int[] nums, List<List<Integer>> ans, List<Integer> cur, int index) {
        ans.add(new ArrayList<>(cur)); // Add the current subset to the result

        // Iterate through the elements starting from the current index
        for (int i = index; i < nums.length; i++) {
            // Skip duplicates: if current number is the same as the previous and it's not the first element in the loop
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // Include nums[i] in the current subset
            cur.add(nums[i]);

            // Recurse with the next index
            solve(nums, ans, cur, i + 1);

            // Backtrack: remove the last element added
            cur.remove(cur.size() - 1);
        }
    }
}
```



---

# 17. Letter Combinations of a Phone Number [solve here](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

```
class Solution {
    private void combinations(List<String> list, String digits, String[] keyPad, String cur, int start) {
        if(start == digits.length()) {
            list.add(cur);
            return;
        }

        char c = digits.charAt(start);
        int n = c - '0';

        for(int i = 0; i < keyPad[n].length(); i++) {
            combinations(list, digits, keyPad, cur + keyPad[n].charAt(i), start + 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) return list;

        String[] keyPad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
        combinations(list, digits, keyPad, "", 0);

        return list;
    }
}
```

![IMG_0060](https://github.com/user-attachments/assets/96533919-bfa9-44c8-8084-d29840ff6f69)


---
# 39. Combination Sum [solve here](https://leetcode.com/problems/combination-sum/)
```
class Solution {
    private void sum(int[] candidates, int target, List<List<Integer>> list, List<Integer> cur, int start) {
        if(target == 0) {
            list.add(new ArrayList<>(cur));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            sum(candidates, target - candidates[i], list, cur, i);
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        sum(candidates, target, list, cur, 0);
        return list;
    }
}
```

![IMG_0061](https://github.com/user-attachments/assets/e1888874-befc-40a6-b011-dcf59997eda6)

---

# 51. N-Queens [solve here](https://leetcode.com/problems/n-queens/description/)

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

---
# 37. Sudoku Solver [solve here](https://leetcode.com/problems/sudoku-solver/)

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

# 40. Combination Sum II [solve here](https://leetcode.com/problems/combination-sum-ii/)

```
class Solution {
    private void fn(int[] candidates, int target, List<List<Integer>> list, List<Integer> cur, int start) {
        if(target == 0) {
            list.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) break;
            cur.add(candidates[i]);
            fn(candidates, target - candidates[i], list, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        fn(candidates, target, list, cur, 0);
        return list;
    }
}
```

![IMG_0062](https://github.com/user-attachments/assets/5e15104f-1de5-4fbd-af47-6cac58e5475d)

---

# 47. Permutations II [solve here](https://leetcode.com/problems/permutations-ii/)

```
class Solution {
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    private void fn(int[] nums, List<List<Integer>> list, int start) {
        if(start == nums.length) {
            List<Integer> cur = new ArrayList<>();
            for(int a: nums) cur.add(a);
            list.add(cur);
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[start]) continue;
            swap(nums, start, i);
            fn(nums, list, start + 1);
        }

        for(int i = nums.length - 1; i > start; i--) {
            swap(nums, start, i);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        fn(nums, list, 0);
        return list;
    }
}
```

---

# 1079. Letter Tile Possibilities [soleve here](https://leetcode.com/problems/letter-tile-possibilities/)

```
class Solution {
    
    private void fn(String tiles, String cur, boolean[] visited, Set<String> set) {
       for(int i = 0; i < tiles.length(); i++) {
            if(visited[i]) continue;
            String charSequence = cur + tiles.charAt(i);
            visited[i] = true;
            set.add(charSequence);
            fn(tiles, charSequence, visited, set);
            visited[i] = false;
       }
    }
    public int numTilePossibilities(String tiles) {
        boolean[] visited = new boolean[tiles.length()];
        Set<String> set = new HashSet<>();
        fn(tiles, "", visited, set);
        return set.size();
    }
}
```

<img width="1000" height="219" alt="image" src="https://github.com/user-attachments/assets/b7416294-6f31-477c-993f-fd2a191f0344" />

---

# 131. Palindrome Partitioning [solve here](https://leetcode.com/problems/palindrome-partitioning/)

```
class Solution {
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private void fn(String s, List<List<String>> list, List<String> cur, int tracker) {
        if(tracker == s.length()) {
            list.add(new ArrayList<>(cur));
            return;
        }

        for(int i = tracker; i < s.length(); i++) {
            String part = s.substring(tracker, i + 1);
            if(isPalindrome(part)) {
                cur.add(part);
                fn(s, list, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        fn(s, list, cur, 0);
        return list;
    }
}
```
