# how to identify dp.
 - For each index we have two choices (one fn can call two or more fn), so the time complexity in recursion becomes 2^n.
 - At that point, we should think about Dynamic Programming (DP).
    -  We need to check whether the state repeats.
    -  If the same state (i, sum) is reached again, the result will always be the same, so we can store it and reuse it.```fn(i, sum)```
    -  This function depends on:
    -  ```(i + 1, sum + nums[i])```
    -  ```(i + 1, sum - nums[i])```

```n ≤ 30```\
```timeComplexity:- 2^10: 10^3.```\
```timeComplexity:- 2^20: 10^6.```\
```timeComplexity:- 2^30: 10^9.``` <- this is the final move implement dp.
-   When it reaches around 2^30 (~10^9) operations, recursion becomes too slow.
At this point, we should implement DP.
-   use extra space for dp becuase memory is cheap but latansy is expancive so thtat we use dp
---
## 1. Fibonacci :

a.  [Fibonacci number](https://leetcode.com/problems/fibonacci-number/)✨\
b.  [Climbing stairs](https://leetcode.com/problems/climbing-stairs/)\
c.  [Minimum jumps to reach the end](https://leetcode.com/problems/jump-game-ii/)\
d.  Friends pairing problem\
e.  Maximum subsequence sum such that no three are consecutive

## 2. 0/1 knapsack problems:
### how to identify?
- each element used once.
- choose or not choose.
- count ways/ maximize/ minimize.
- counstrant on total sum.
- are element used at most once
- sum/capacity/target
    - subset sum equal target.
    - partition equal.
- does order not mater
   - if order matters -> usually permutation / dp diffrent type.

a.  [0/1 Knapsack Problem](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1)✨✨\
b.  [Equal sum partition](https://leetcode.com/problems/partition-equal-subset-sum/)✨✨\
c.  [Target sum](https://leetcode.com/problems/target-sum/)✨✨\
d.  [Subset sum](https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1)\
e.  [Count of subsets sum with a given sum](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1)\
f.  [Minimum subset sum difference](https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1) s - 2 * s1\
g. [Count the number of subset with a given difference](https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1)✨

## 3. Unbounded Knapsack :
a.  Integer Break\
b.  [Coin Change](https://leetcode.com/problems/coin-change/)\
c.  [Coin Change 2](https://leetcode.com/problems/coin-change-ii/)\
d.  Combination Sum IV\
e.  [Perfect Squares](https://leetcode.com/problems/perfect-squares/)

## 4. Longest Common Subsequence

a. [Longest common substring](https://leetcode.com/problems/longest-common-subsequence/)\
b. [Shortest common supersequence](https://leetcode.com/problems/shortest-common-supersequence/description/)✨✨\
c. [Longest common substring](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1)\
d. [Delete Operation for Two Strings](https://leetcode.com/problems/delete-operation-for-two-strings/)\
c. Minimum number of insertion and deletion to convert A to B\
d. Longest repeating subsequence\
e. Length of longest subsequence of A which is substring of B\
f. Subsequence pattern matching\
g. [Count how many times A appears as subsequence in B](https://www.geeksforgeeks.org/problems/find-number-of-times-a-string-occurs-as-a-subsequence3020/1)✨\
h. [Longest palindromic subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)\
j. Count of palindromic substrings\
k. Minimum number of deletion in a string to make it palindrome\
l. Minimum number of insertion in a string to make it palindrome\
m. Uncrossed Lines

## 5. Longest Increasing Subsequence

Print longest increasing subsequence\
Number of longest increasing subsequences\
Longest non-decreasing subsequence\
Find the longest increasing subsequence in circular manner\
Longest bitonic subsequence\
Longest arithmetic subsequence\
Maximum sum increasing subsequence

## 6. Matrix Chain Multiplication

a. [Matrix Chain Multiplication](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1)✨\
b. [Burst Balloons](https://leetcode.com/problems/burst-balloons/)\
c. Evaluate expression to true / boolean parenthesization\
d. Minimum or maximum value of a expression\
e. [Palindrome partitioning 2](https://leetcode.com/problems/palindrome-partitioning-ii/)\
d. Scramble string\
f. Super Egg Drop

## 7. DP on Trees

Diameter of Binary Tree\
Binary Tree Maximum Path Sum\
Unique Binary Search Trees II\
House Robber III\
Sum of Distances in Tree

## 8. DP on Grids

Unique Paths\
Unique Paths II\
Minimum Path Sum\
Dungeon Game\
Cherry Pickup

## 9. Prefix–Suffix DP (Left–Right DP)

[Longest Arithmetic Sequence After Changing At Most One Element](https://leetcode.com/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/)

## 10. Digit DP

## 11. State Compression / Advanced DP

Combination of multiple ideas.

Examples:

DP with bitmask + graph

DP with prefix sums

DP with monotonic queue
