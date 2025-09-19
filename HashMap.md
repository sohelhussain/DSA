# 1. two sum
```
    public int[] twoSum(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();

       for(int i = 0; i < nums.length; i++){
        int comp = target - nums[i];
        if(map.containsKey(comp)){
            return new int[]{i, map.get(comp)};
        }else{
            map.put(nums[i],i);
        }
       } 

       return null;
    }
```
---
# 53. Maximum Subarray
### map
```
  pub fn max_sub_array(nums: Vec<i32>) -> i32 {
        let mut max_sum = nums[0];
        let mut cur_sum = 0;

        for a in nums {
            cur_sum += a;
            max_sum = max_sum.max(cur_sum);

            if cur_sum < 0 {
                cur_sum = 0;
            }
        }

        max_sum
    }
```
---

# 409. Longest Palindrome
```
  public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
          map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;

        boolean isOdd = false;

        for(int v: map.values()){
          if(v%2 == 0)
            ans += v;
            else {
              ans += v - 1;
              isOdd = true;
            }
        }

        return isOdd ? ans + 1 : ans;
    }

```
### using set
```
class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
                ans += 2;
            }else {
                set.add(c);
            }
        }

        return set.isEmpty() ? ans : ans + 1;
    }
}
```
### bit
```
class Solution {
    public int longestPalindrome(String s) {
        int[] bit = new int[123];
        for(char ch: s.toCharArray()) bit[ch]++;
        int ans = 0, odd = 0;
        for(int i = 65; i < 123; i++) {
            if(bit[i] % 2 == 0) {
                ans += bit[i];
            }else {
                ans += bit[i] - 1;
                odd = 1;
            }

            if(i == 90) i = 96;
        }

        return ans + odd;
    }
}
```
---
# 560. Subarray Sum Equals K
```
  public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int diff = sum - k;

            if(map.containsKey(diff)) {
                ans += map.get(diff);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum) + 1);
            }else{
                map.put(sum, 1);
            }
        }

        return ans;
    }
}
```
