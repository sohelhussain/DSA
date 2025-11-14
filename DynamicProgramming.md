# 1. fibonacci O(2^n)
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
## with dp O(n) using memoization
```
public class Solution {
    private static int dfs(int n, Integer[] dp) {
        if(n <= 1) return n;

        if(dp[n] != null) return dp[n];

        return dp[n] = dfs(n - 1, dp) + dfs(n - 2, dp);
    }
    
    public static void main(String[] args) {
       int n = 4;
       Integer[] dp = new Integer[n + 1];
       System.out.println(dfs(n, dp));
    }    
}
```
## using tabulation
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
## space optimization
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
# 2. Climbing Stairs [solve here](https://leetcode.com/problems/climbing-stairs/)
```
class Solution {
    private int dfs(int n, Integer[] dp) {
        if(n <= 3) return n;
        if(dp[n] != null) return dp[n];
        return dp[n] = dfs(n - 1, dp) + dfs(n - 2, dp);
    }
    public int climbStairs(int n) {
        Integer[] dp = new Integer[n + 1];
        return dfs(n, dp);
    }
}
```
# 3. Min Cost Climbing Stairs [solve here](https://leetcode.com/problems/min-cost-climbing-stairs/)
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
---
# 4. Jump Game [solve here](https://leetcode.com/problems/jump-game/)
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
# 1143. Longest Common Subsequence [solve here](https://leetcode.com/problems/longest-common-subsequence/)
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
# Longest Common Substring [solve here](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1)

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
#
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
            return dp[n][c] = Math.max(dfss(w, v, c - w[n - 1], n - 1, dp) + v[n - 1], dfss(w, v, c, n - 1, dp));
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
