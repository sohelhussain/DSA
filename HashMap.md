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
# 349. Intersection of Two Arrays [solve here](https://leetcode.com/problems/intersection-of-two-arrays/description/)
```
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            int n = nums1[i];
            set1.add(n);
        }
        for(int i = 0; i < nums2.length; i++) {
            int n = nums2[i];
            set2.add(n);
        }
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer :: intValue).toArray();
    }
}
```
---
# 53. Maximum Subarray
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
### map
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
# 128. Longest Consecutive Sequence [solve here](https://leetcode.com/problems/longest-consecutive-sequence/)
but this code give TLE
```
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(); 
        for(int num : nums) 
            set.add(num);
        int max = 0; 
        for(int num : nums) {
            int c = 1; 
            if(set.contains(num - 1)) 
                continue;
            else if(set.contains(num + 1)) {
                while(set.contains(++num)) 
                    c++;
            }
            max = Math.max(max, c);
        }
        return max; 
    }
}
```
```
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            else if (nums[i] == nums[i-1] + 1) {
                currentStreak++;
            }
            else {
                currentStreak = 1;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;
    }
}
```
```
class Solution {
    public int longestConsecutive(int[] nums) {
Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : set) {
            // Start only if it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int count = 1;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
```
