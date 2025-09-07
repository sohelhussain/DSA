
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
    
