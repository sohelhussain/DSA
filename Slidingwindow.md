```when i increase then reduce the i'th element on the sum, when j is increase then add a j'th element into sum```
### how to find subString length ```j - i + 1```

# 1. Max Sum Subarray of size K [solve here](https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1)
```
class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        while(j < arr.length) {
            sum += arr[j];
            if(j - i + 1 < k) {
                j++;
            }else if(j - i + 1 == k) {
                maxSum = Integer.max(maxSum, sum);
                sum -= arr[i];
                i++;
                j++;
            }
        }
        return maxSum;

    }
}
```
---
# 2. Maximum Points You Can Obtain from Cards [solve here](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
```
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        for(int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        maxSum = leftSum;
        int j = cardPoints.length - 1;

        for(int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[j];
            j--;
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}
```
---
# 3. Count Occurences of Anagrams [solve here](https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1)

```
class Solution {

    int search(String pat, String txt) {
        int i = 0, j = 0, count = 0;
        int[] patArr = new int[26];
        for(int k = 0; k < pat.length(); k++) {
            char ch = pat.charAt(k);
            patArr[ch - 97]++;
        }
        int[] txtArr = new int[26];
        while(j < txt.length()) {
            char ch = txt.charAt(j);
            txtArr[ch - 97]++;
            if(j - i + 1 == pat.length()) {
                if(Arrays.equals(patArr,txtArr)) count++;
                txtArr[txt.charAt(i) - 97]--;
                i++;j++;
            }
            if(j - i + 1 < pat.length()) j++;
        }
        return count;
    }
}
```
---
# 4. largest/longest subarray of sum k
```
public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,1,1};
        int i = 0, j = 0, maxLength = 0, sum = 0;
        int k = 3;
        while(j < nums.length) {
            sum += nums[j];
            while(i <= j &&sum > k) {
                sum -= nums[i];
                i++;
            }
            if(sum == k) maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
}
```
---
# 5. Fruit Into Baskets [solve here](https://leetcode.com/problems/fruit-into-baskets/)
```
class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            while(map.size() > 2) {
                if(map.get(fruits[i]) == 1) map.remove(fruits[i]);
                else map.put(fruits[i], map.get(fruits[i]) - 1);
                i++;
            }
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }
        return maxLength;
    }
}
```
---
# 6. Longest Substring Without Repeating Characters [solve here](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        if(s.length() == 0 || s.length() == 1) return s.length();
        HashSet<Character> map = new HashSet<>();
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(!map.contains(ch)) {
                map.add(ch);
                max = Math.max(max, j - i + 1);
                j++;
            }else {
                map.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
```
---
# 7. Minimum Window Substring [solve here](https://leetcode.com/problems/minimum-window-substring/)
```
class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLength = Integer.MAX_VALUE, i = 0, minStart = 0, count = 0;
        for(int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) >= 0) count++;
            }
            while(count == t.length()) {
                if(minLength > j - i + 1) {
                    minLength = j - i + 1;
                    minStart = i;
                }
                if(map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if(map.get(s.charAt(i)) > 0) count--;
                }
                i++;
            }
        }
        if(minLength > s.length()) return "";
        return s.substring(minStart, minStart + minLength);
    }
}
```
