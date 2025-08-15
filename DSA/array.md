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

---

# 1299. Replace Elements with Greatest Element on Right Side [solve here](https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/)

```
class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        if(n == 1) return new int[]{-1};
        int[] gretElement = new int[n];
        int maxElem = -1;
        for(int i = n - 1; i >= 0; i--) {
            gretElement[i] = maxElem;
            maxElem = Math.max(arr[i], maxElem);
        }

        return gretElement;
    }
}
```
