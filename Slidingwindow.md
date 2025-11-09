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
