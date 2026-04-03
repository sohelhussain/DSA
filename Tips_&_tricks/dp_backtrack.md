# DP
DFS → loop inside recursion\
DP → loop outside + nested loop inside
memo
  ```
  Integer[] dp;

  int dfs(int state) {
      if (state == base_condition) return value;
      if (dp[state] != null) return dp[state];
  
      int ans = INITIAL_VALUE;
  
      // 🔑 TRY ALL CHOICES (loop inside DFS) this is a nested loop
      for (choice in choices) {
          ans = combine(ans, dfs(next_state));
      }
  
      return dp[state] = ans;
  }
  ```
tabu
```
int[] dp = new int[n + 1];
dp[base] = value;

// BUILD from smaller → larger
for (int i = 1; i <= n; i++) {

    int ans = INITIAL_VALUE;

    // 🔑 TRY ALL CHOICES (nested loop)
    for (choice in choices) {
        ans = combine(ans, dp[previous_state]);
    }

    dp[i] = ans;
}
```
---
# BACKTRACK
