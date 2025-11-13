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
