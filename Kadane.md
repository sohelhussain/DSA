# Identification
1. subArray (contiguous) [+ve, -ve, 0];
2. finding best(maximum, minimum)
3. in product, freq
---
```
nums = [5,-3,5]
           i

bestEndingHere =
max(
    extend previous subarray,
    start new subarray
)
```
now i have a two choise
1. we can add into bestEndin + nums[i];
2. or we just add nums[i]

give me a best(max, min) in both of them.

dp like approch.
```
int bestEnding = nums[0];
int res = nums[0];

for(int i = 1; i < nums.length; i++) {
    int v1 = bestEnding + nums[i];
    int v2 = nums[i];

    bestEnding = Math.max(v1, v2);
    res = Math.max(bestEnding, res);
}
```
greedy like approch.
```
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int largestSum = nums[0];
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += nums[i];
            largestSum = Math.max(largestSum, sum);

            if(sum < 0) {
                sum = 0;
            }
        }

        return largestSum;
    }
}
```



# question
[Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)✨\
[Minimum Subarray](https://www.geeksforgeeks.org/problems/smallest-sum-contiguous-subarray/1)\
[maximum product subarray](https://leetcode.com/problems/maximum-product-subarray/)✨\
[maximum subarray sum with one deletion](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/)\
[Maximum Absolute Sum of Any Subarray](https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/)\
[Maximum Sum Circular Subarray](https://leetcode.com/problems/maximum-sum-circular-subarray/)✨\
[Beautiful Array](https://codeforces.com/problemset/problem/1155/D)\
[Maximum Sum Submatrix](https://www.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1)
