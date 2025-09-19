# 1051. Height Checker [solve here]() 
```
class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for(int h: heights) {
            count[h]++;
        }
        List<Integer> expected = new ArrayList<>();
        for(int h = 1; h <= 100; h++) {
            int c = count[h];
            for(int i = 0; i < c; i++) {
                expected.add(h);
            }
        }
        int res = 0;
        for(int i = 0; i < heights.length; i++) {
            if(heights[i] != expected.get(i)) {
                res++;
            }
        }
        return res;
    }
}
```
# 75. Sort Colors [solve here](https://leetcode.com/problems/sort-colors/) 
```
class Solution {
    private void swap(int[] nums, int start, int mid) {
        int temp = nums[start];
        nums[start] = nums[mid];
        nums[mid] = temp;
    }
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;

        while(end >= mid) {
            if(nums[mid] == 0) {
                swap(nums, start++, mid++);
            }else if(nums[mid] == 2) {
                swap(nums, end--, mid);
            }else {
                mid++;
            }
        }
    }
}
```
---
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

---
# 121. Best Time to Buy and Sell Stock [solve here](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
```
class Solution {
    public int maxProfit(int[] prices) {
        int minimumPrice = prices[0], maximumProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maximumProfit = Math.max(maximumProfit, prices[i] - minimumPrice);
            minimumPrice = Math.min(minimumPrice, prices[i]);
        }
        return maximumProfit;

    }
}
```
---

# 169. Majority Element [solve here](https://leetcode.com/problems/majority-element/)
```
class Solution {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int candidate = nums[0];

        for(int i = 0; i < nums.length; i++) {
            if(candidate == nums[i]) {
                vote++;
            }else {
                vote--;
            }
            if(vote <= 0) {
                candidate = nums[i];
                vote = 1;
            }
        }

        return candidate;
    }
}
```
---

# 605. Can Place Flowers [solve here](https://leetcode.com/problems/can-place-flowers/)
```
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;

        for(int i = 0; i < l; i++) {
            if(flowerbed[i] == 0 &&
             (i == 0 || flowerbed[i - 1] == 0) &&
             (i == l - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
             }

             if(n <= 0) return true;
        }

        return n <= 0;
    }
}
```


---

# 896. Monotonic Array [solve here](https://leetcode.com/problems/monotonic-array/)
```
class Solution {
    public boolean isMonotonic(int[] nums) {
        int n = nums.length;

        if(nums[0] <= nums[n - 1]) {
            for(int i = 1; i < n; i++) {
                if(nums[i] < nums[i - 1]) {
                    return false;
                }
            }
            return true;
        }else {
            for(int i = 1; i < n; i++) {
                if(nums[i] > nums[i - 1]) {
                    return false;
                }
            }
            return true;
        }
    }
}
```
---

# 1752. Check if Array Is Sorted and Rotated [solve here](https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/)
```
class Solution {
    public boolean check(int[] nums) {

        int n = nums.length;
        int drop = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[(i + 1) % n]) {
                drop++;
            }
        }

        if(drop > 1) {
            return false;
        }

        return true;
    }
}
```
---

# 1700. Number of Students Unable to Eat Lunch [solve here](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/)

```
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0, zero = 0;

        for(int s: students) {
            if(s == 1) ones++;
            else zero++;
        }


        for(int s: sandwiches) {
            if(s == 0) {
                if(zero == 0) return ones;
                zero--;
            }else {
                if(ones == 0) return zero;
                ones--;
            }
        }

        return 0;
    }
}
```

[solve by queue]()

---

# 42. Trapping Rain Water [solve here](https://leetcode.com/problems/trapping-rain-water/)
```
  public int trap(int[] height) {
        int l = height.length;
        int[] leftGretest = new int[l];
        int[] rightGretest = new int[l];

        leftGretest[0] = height[0];
        for(int i = 1; i < l; i++){
            leftGretest[i] = Math.max(leftGretest[i - 1], height[i]);
        }

        rightGretest[l - 1] = height[l - 1];
        for(int i = l-2; i >= 0; i--){
            rightGretest[i] = Math.max(rightGretest[i + 1], height[i]);
        }

        int ans = 0;
        for(int i = 0; i < l; i++){
            int water = Math.min(leftGretest[i], rightGretest[i]) - height[i];
            if(water > 0){
                ans += water;
            }
        }

        return ans;
}
```
---
# 11. Container With Most Water [solve here](https://leetcode.com/problems/container-with-most-water/)
```
  public int maxArea(int[] height) {
        int length = height.length;
        int i = 0, j = length - 1;

        int maxWaterArea = 0;
        while(i < j){
            int minWidth = Math.min(height[i], height[j]);
            maxWaterArea = Math.max(maxWaterArea, (j - i) * minWidth);
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }

        return maxWaterArea;
}
```
