# 1. fibonacci O(2^n) [solve here](https://leetcode.com/problems/fibonacci-number/)
```
public class Solution {

    private static int dfs(int n) {
        if(n <= 1) return n;

        return dfs(n - 1) + dfs(n - 2);
    }
    
    public static void main(String[] args) {
       int n = 46;
       System.out.println(dfs(n));
    }
}
```
### with dp O(n) using memoization
```
public class Solution {
    private static int dfs(int n, Integer[] dp) {
        if(n <= 1) return n;

        if(dp[n] != null) return dp[n]; 

        return dp[n] = dfs(n - 1, dp) + dfs(n - 2, dp);
    }
    
    public static void main(String[] args) {
       int n = 4;
       Integer[] dp = new Integer[n + 1]; // dp of size n + 1 because you want to store values from index 0 to n
       System.out.println(dfs(n, dp));
    }    
}
```
### using tabulation
```
public class Solution {
   public static void main(String[] args) {
       int n = 4;
       Integer[] dp = new Integer[n + 1];
       dp[0] = 0;
       dp[1] = 1;

       for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
       }

       System.out.println(dp[n]);
  }     
}
```
### space optimization
```
public class Solution {
  public static void main(String[] args) {
       int n = 4;
       int dp0 = 0;
       int dp1 = 1;
       for(int i = 2; i <= n; i++) {
            int temp = dp0 + dp1;
            dp0 = dp1;
            dp1 = temp;
       }

       System.out.println(dp1);
    }
}     
```
---
## 2. Climbing Stairs [solve here](https://leetcode.com/problems/climbing-stairs/)
```
class Solution {
    private int dfs(int n, Integer[] dp) {
        if(n <= 3) return n;
        if(dp[n] != null) return dp[n];
        return dp[n] = dfs(n - 1, dp) + dfs(n - 2, dp); // wher are you come from on nth stairs may be you come from n - 1 or n - 2 stairs.
    }
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        return dfs(n, dp);
    }
}
```
## 3. Min Cost Climbing Stairs [solve here](https://leetcode.com/problems/min-cost-climbing-stairs/)

1. Brute force recursion → O(2^n)
2. For n = 1000 → 2^1000 → impossible
3. So immediately you know:
   -> If recursion has branching (2 choices every step) and n is up to 1000 → it must be DP.
4. “Minimum cost”
    Optimization problem → classic DP signal.
5. “From each step you can go to i+1 or i+2” -> current state depends on smaller future states
   ```f(i) = cost[i] + min(f(i+1), f(i+2))``` It is DP.

```
class Solution {
    private int dfs(int n, int[] cost, Integer[] dp) {
        if(n <= 1) return cost[n];

        if(dp[n] != null) return dp[n];

        return dp[n] = Math.min(dfs(n - 1, cost, dp), dfs(n - 2, cost, dp)) + cost[n];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[n + 1];
        return Math.min(dfs(n - 1, cost, dp), dfs(n - 2, cost, dp));
    }
}
```
```
class Solution {
    Integer[] dp;
    private int dfs(int i, int[] cost) {
        if(i >= cost.length) return 0;
        if(dp[i] != null) return dp[i];
        int n1Step = dfs(i + 1, cost);
        int n2Step = dfs(i + 2, cost);

        return dp[i] = Math.min(n1Step, n2Step) + cost[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new Integer[cost.length + 1];
        return Math.min(dfs(0, cost), dfs(1, cost));
    }
}
```
### tabu
```
class Solution {
    Integer[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new Integer[n + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for(int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + (i == n ? 0 : cost[i]);
        }

        return dp[n];
    }
}
```
### space optimize O(1)
```
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];

        for(int i = 2; i <= n; i++) {
            int cur = Math.min(first, second) + (i == n ? 0 : cost[i]);
            first = second;
            second = cur;
        }

        return second;
    }
}
```
---
## 4. Jump Game [solve here](https://leetcode.com/problems/jump-game/)
```
class Solution {
    private boolean dfs(int[] nums, int n, Boolean[] dp) {
        if(n == nums.length - 1) return true;

        if(dp[n] != null) return dp[n];

        boolean ans = false;
        for(int i = 1; i <= nums[n]; i++) {
            if(i + n < nums.length) {
                ans = dfs(nums, i + n, dp);
                if(ans) break;
            }
        }
        return dp[n] = ans;
    }
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return dfs(nums, 0, dp);
    }
}
```
---
# 5. 0/1 Knapsack [solve here](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)
#### smaller input
```
Capacity = 5
Weights = {2, 3}
Values = {4, 5}
output = 9
```
![IMG_0151](https://github.com/user-attachments/assets/8f976810-52ab-42db-9209-c959f5f7e195)
```
public class Solution {
    
    public static int dfs(int[] w, int[] v, int c, int n) {
        if(n == 0 || c == 0) {
            return 0;
        }
        if (w[n - 1] > c) {
            return dfs(w, v, c, n - 1);
        }else {
            return Math.max(dfs(w, v, c - w[n - 1], n - 1) + v[n - 1], dfs(w, v, c, n - 1));
        }
    }
    public static void main(String[] args) {
        int c = 10;
        int[] weight = {3,1,5,4,9};
        int[] value = {4,3,8,8,10};
        System.out.println(dfs(weight, value, c, weight.length, dp));
    }
}
```
### using dp memoization
```
public class Solution {
    
    public static int dfss(int[] w, int[] v, int c, int n, Integer[][] dp) {
        if(n == 0 || c == 0) {
            return 0;
        }
        if (dp[n][c] != null) {
            return dp[n][c];
        }
        if (w[n - 1] > c) {
            return dp[n][c] = dfss(w, v, c, n - 1, dp);
        }else {
            int take = dfss(w, v, c - w[n - 1], n - 1, dp) + v[n - 1];
            int notTake = dfss(w, v, c, n - 1, dp);
            return dp[n][c] = Math.max(take, notTake);
        }
    }
    public static void main(String[] args) {
        int c = 10;
        int[] weight = {3,1,5,4,9};
        int[] value = {4,3,8,8,10};
        Integer[][] dp = new Integer[weight.length + 1][c + 1];
        System.out.println(dfss(weight, value, c, weight.length, dp));
    }
}
```
### tabulation
```
public class Solution {
    public static void main(String[] args) {
        int c = 10;
        int[] weight = {3,1,5,4,9};
        int[] value = {4,3,8,8,10};
        Integer[][] dp = new Integer[weight.length + 1][c + 1];

        for (int i = 0; i <= weight.length; i++) {
            for (int j = 0; j <= c; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }else if (weight[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weight[i - 1]] + value[i - 1], dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int ans = dp[weight.length][c];

        for (Integer[] integers : dp) {
            System.out.println(Arrays.toString(integers));
        }
        System.out.println(ans);
    }
}
```
---
## 6. Partition Equal Subset Sum [solve here](https://leetcode.com/problems/partition-equal-subset-sum/)
question says ```1, 5, 5 || 11 = true (11 + 11 => 22 even)```
```array sum / 2```
### memo
```
class Solution {
    Boolean[][] dp;
    private boolean dfs(int[] nums, int target, int n) {
        if(dp[n][target] != null) return dp[n][target];

        if(nums[n - 1] > target) {
            return dp[n][target] = dfs(nums, target, n - 1);
        }else {
            boolean take = dfs(nums, target - nums[n - 1], n - 1);
            boolean notTake = dfs(nums, target, n - 1);

            return dp[n][target] = take || notTake;
        }
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num: nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false;
        else sum = sum / 2;
        dp = new Boolean[n + 1][sum + 1];

        for(int i = 0; i <= n; i++) dp[i][0] = true;
        for(int i = 0; i <= sum; i++) dp[0][i] = false;

        return dfs(nums, sum, n);
    }
}
```
### tabulation
```
class Solution {
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;

        int target = sum / 2;
        dp = new boolean[nums.length + 1][target + 1];

        for(int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= target; j++) {

                if(j >= nums[i - 1]) {
                    boolean take = dp[i - 1][j - nums[i - 1]];
                    boolean notTake = dp[i - 1][j];
                    dp[i][j] = take || notTake;
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][target];
    }
}
```
| Approach    | Time Complexity | Extra Stack |
| ----------- | --------------- | ----------- |
| Memoization | O(n * target)   | Yes (O(n))  |
| Tabulation  | O(n * target)   | No          |
---
## 7. Target Sum [solve here](https://leetcode.com/problems/target-sum/)
### simmiler gfg ```Perfect Sum Problem``` [solve here](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1)
```
class Solution {
    Integer[][] dp;
    private int dfs(int n, int[] nums, int sum) {
        if(dp[n][sum] != null) {
            return dp[n][sum];
        }
        if(nums[n - 1] > sum) {
            return dp[n][sum] = dfs(n - 1, nums, sum);
        }else {
            int take = dfs(n - 1, nums, sum - nums[n - 1]);
            int notTake = dfs(n - 1, nums, sum);
            return dp[n][sum] = take + notTake;
        }
    }
    private int fn_dp(int n, int[] nums, int sum) {
        dp = new Integer[n + 1][sum + 1];
        for(int i = 0; i <= sum; i++) {
            dp[0][i] = 0;
        }
        dp[0][0] = 1;
        return dfs(n, nums, sum);
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        target = Math.abs(target);

        for(int num: nums) {
            sum += num;
        }

        if (target > sum || (target + sum) % 2 == 1) return 0;


        return fn_dp(n, nums, (target + sum) / 2);
    }
}
```
## Subset Sum Problem [solve here](https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)
```
class Solution {
    static Boolean[][] dp;
    static Boolean dfs(int i, int currentSum, int arr[], int sum) {
        if(currentSum == sum) {
            return true;
        }
        if(i >= arr.length) return false;
        
        if(dp[i][currentSum + sum] != null) return dp[i][currentSum + sum];
        
        Boolean take = false;

        if (currentSum + arr[i] <= sum) {
            take = dfs(i + 1, currentSum + arr[i], arr, sum);
        }

        Boolean notTake = dfs(i + 1, currentSum, arr, sum);

        return dp[i][currentSum] = take || notTake;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        dp = new Boolean[arr.length][sum + 1];
        return dfs(0, 0, arr, sum);
    }
}
```
```
class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                if (arr[i - 1] <= j) {
                    boolean take = dp[i - 1][j - arr[i - 1]];
                    boolean notTake = dp[i - 1][j];
                    dp[i][j] = take || notTake;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
```
# 8. Coin Change II [solve here](https://leetcode.com/problems/coin-change-ii/)
```
class Solution {
    private int dfs(int n, int amount, int[] coins, Integer[][] dp) {
        if(dp[n][amount] != null) {
            return dp[n][amount];
        }

        if(coins[n - 1] > amount) {
            return dp[n][amount] = dfs(n - 1, amount, coins, dp);
        }else {
            int take = dfs(n, amount - coins[n - 1], coins, dp);
            int notTake = dfs(n - 1, amount, coins, dp);
            return dp[n][amount] = take + notTake;
        }
    }
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n + 1][amount + 1];
        for(int i = 0; i <= amount; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        return dfs(n, amount, coins, dp);
    }
}
```
---
# 9. Coin Change [solve here](https://leetcode.com/problems/coin-change/)
```
class Solution {

    Integer[] dp;

    private int dfs(int[] coins, int amount) {
        if (amount == 0) return 0;
        if(amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[amount] != null) return dp[amount];

        int minStep = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = dfs(coins, amount - coins[i]);
            if (res != Integer.MAX_VALUE) {
                minStep = Math.min(minStep, 1 + res);
            }
        }
        return dp[amount] = minStep;
    }

    public int coinChange(int[] coins, int amount) {
        dp = new Integer[amount + 1];
        int ans = dfs(coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
```
```
class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int coin: coins) {
                if(i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
```
---
# 10. Longest Common Subsequence [solve here](https://leetcode.com/problems/longest-common-subsequence/)
![IMG_0148](https://github.com/user-attachments/assets/0c8715d3-3271-4e7e-9d85-45163a306fc0)
### without using dp simple recursion
```
class Solution {
    private int dfs(String t1, String t2, int i, int j) {
        if(i == -1 || j == -1) {
            return 0;
        }else if(t1.charAt(i) == t2.charAt(j)) {
            return 1 + dfs(t1, t2, i - 1, j - 1);
        }else {
            return Math.max(dfs(t1, t2, i - 1, j), dfs(t1, t2, i, j - 1));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return dfs(text1, text2, text1.length() - 1, text2.length() - 1);
    }
}
```
### with dp
```
class Solution {
    private int dfs(String t1, String t2, int i, int j, Integer[][] dp) {
        if(i == 0 || j == 0) {
            return 0;
        }else if(dp[i][j] != null) {
            return dp[i][j];
        }else if(t1.charAt(i - 1) == t2.charAt(j - 1)) {
            return dp[i][j] = 1 + dfs(t1, t2, i - 1, j - 1, dp);
        }else {
            return dp[i][j] = Math.max(dfs(t1, t2, i - 1, j, dp), dfs(t1, t2, i, j - 1, dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length() + 1][text2.length() + 2];
        return dfs(text1, text2, text1.length(), text2.length(), dp);
    }
}
```
### top - down
![IMG_0149](https://github.com/user-attachments/assets/1e7a602e-180a-4d26-8f17-265c2e0df13b)
```
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 2];

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
```
---
# 11. Longest Common Substring [solve here](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1)
### two pointer n^2
```
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int max = 0;
        for (int i = 0; i < n; i++) {           
            for (int j = 0; j < m; j++) {
                int k = 0; // pointer to extend matching substring
                while (i + k < n && j + k < m && s1.charAt(i + k) == s2.charAt(j + k)) {
                    k++;
                }       
                max = Math.max(max, k);
            }
        }
        return max;
    }
}
```
### top - down dp
```
class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int max = 0;

        for(int i = 1; i <= s1.length(); i++) {
            for(int j = 1; j <= s2.length(); j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j], max);
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
```
---
# 12. Delete Operation for Two Strings [solve here](https://leetcode.com/problems/delete-operation-for-two-strings/)
```

```
---
# 13. Shortest Common Supersequence [solve here](https://leetcode.com/problems/shortest-common-supersequence/)
```
```
---
# 14. Longest Palindromic Subsequence [solve here](https://leetcode.com/problems/longest-palindromic-subsequence)
```
```
---
# 15. Longest Palindromic Substring [solve here](https://leetcode.com/problems/longest-palindromic-substring/)
```
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int max = 0, l = 0, r = 0;

        int[][] dp = new int[n][n];

        for(int k = 0; k < n; k++) {
            for(int i = 0, j = k; j < n; i++, j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }else if(k == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                }else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
                if(dp[i][j] == 1) {
                    if(j - i + 1 > max) {
                        max = j - i + 1;
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return s.substring(l, r + 1);
    }
}
```
---
# 16. Palindromic Substrings [solve here](https://leetcode.com/problems/palindromic-substrings/)
```
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0, l = 0, r = 0;

        int[][] dp = new int[n][n];

        for(int k = 0; k < n; k++) {
            for(int i = 0, j = k; j < n; i++, j++) {
                if(i == j) {
                    dp[i][j] = 1;
                }else if(k == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 1;
                }else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
                if(dp[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
```
---
# 17. Palindrome Partitioning [solve here](https://leetcode.com/problems/palindrome-partitioning/)
```
class Solution {
    private void dfs(String s, List<List<String>> list, List<String> cur, boolean[][] dp, int tracker) {
        if(tracker == s.length()) {
            list.add(new ArrayList<>(cur));
            return;
        }
        for(int i = tracker; i < s.length(); i++) {

            if(dp[tracker][i]) {
                String subString = s.substring(tracker, i + 1);
                cur.add(subString);
                dfs(s, list, cur, dp, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int k = 0; k < n; k++) {
            for(int i = 0, j = k; j < n; i++, j++) {
                if(i == j) {
                    dp[i][j] = true;
                }else if(s.charAt(i) == s.charAt(j) && j - i == 1) {
                    dp[i][j] = true;
                }else if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        List<List<String>> list = new ArrayList<>();
        List<String> cur = new ArrayList<>();

        dfs(s, list, cur, dp, 0);
        return list;
    }
}
```
---
# 18. Minimum Insertion Steps to Make a String Palindrome [solve here](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
```

```
---
# 19. Edit Distance [solve here](https://leetcode.com/problems/edit-distance/)
```
class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for(int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for(int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }

        for(int i = 1; i <= l1; i++) {
            for(int j = 1; j <= l2; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    int insert = dp[i][j - 1];
                    int delete = dp[i - 1][j];
                    int replace = dp[i - 1][j - 1];

                    dp[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[l1][l2];
    }
}
```
---
# Matrix Chain Multiplication [solve here](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)
```
dfs(1,3)
 ├── k=1
 │    ├── dfs(1,1)=0
 │    └── dfs(2,3)=12
 │
 └── k=2
      ├── dfs(1,2)=6
      └── dfs(3,3)=0
```
```
class Solution {
    static Integer[][] dp;
    static int dfs(int i, int j, int[] arr) {
        if (i >= j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int min = (int) 1e9;

        for (int k = i; k <= j - 1; k++) {
            int cost = dfs(i, k, arr)
                     + dfs(k + 1, j, arr)
                     + arr[i - 1] * arr[k] * arr[j];

            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }

    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        dp = new Integer[n][n];
        return dfs(1, n - 1, arr);
    }
}
```
```
class Solution {

    static int matrixMultiplication(int arr[]) {
        int n = arr.length;

        int[][] dp = new int[n][n];

        for (int len = 2; len < n; len++) {   // chain length
            for (int i = 1; i <= n - len; i++) {

                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    int cost = dp[i][k] 
                             + dp[k + 1][j] 
                             + arr[i - 1] * arr[k] * arr[j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[1][n - 1];
    }
}
```
