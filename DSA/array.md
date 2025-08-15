# 1929. Concatenation of Array [solve here](https://leetcode.com/problems/concatenation-of-array/)

```
class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] concat = new int[n + n];

        for(int i = 0; i < n; i++) {
            concat[i] = nums[i];
        }

        for(int i = n; i < n + n; i++) {
            concat[i] = nums[i - n];
        }

        return concat;
    }
}
```
