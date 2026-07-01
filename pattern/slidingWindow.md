# when i need to apply.

1. array / string
2. subArray(continues) / substring / consecutive (n, n+1, n+2) / contiguous (Neighboring in Position).
3. most of the time positive.
4. max / min / longest / sortest / sum / count / average.
5. at most k / at least k / exactly k.
6. binary circular array

## 1.Fixed Size Window
Keywords:

size k\
permutation\
anagram\
exact length

Pattern:
```
if(windowSize > k) {
    remove left
}
```

Examples:

Find All Anagrams\
Permutation in String\
Maximum sum subarray of size k

## 2.Variable Size Window

### 1. maximun
i saw a pattern that output is maxLen
```
while(right < n) {

    add current element

    while(window invalid) {
        remove left element
        left++
    }

    update answer

    right++
}
```
[Longest Substring with K Distinct Characters](https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1)\
[Fruits into Baskets](https://leetcode.com/problems/fruit-into-baskets/)\
[Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)\
[Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)\
[Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)\


### 2. minimum
```
while(right < n) {

    add current element

    while(window correct) {
        update answer
        remove left element
        left++
    }

    right++
}
```
[Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)\
[Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)

## 3. Fixed Sliding Window + Frequency Map Template
Used for:

anagrams\
permutation\
exact size k\
frequency matching

Examples:

Permutation in String\
Find All Anagrams
```
int[] targetFreq = new int[26];
int[] windowFreq = new int[26];

// build target frequency
for(char ch : target.toCharArray()) {
    targetFreq[ch - 'a']++;
}

int i = 0;

for(int j = 0; j < s.length(); j++) {

    // add current character
    windowFreq[s.charAt(j) - 'a']++;

    // maintain fixed window size
    if(j - i + 1 > target.length()) {

        windowFreq[s.charAt(i) - 'a']--;

        i++;
    }

    // compare window
    if(Arrays.equals(targetFreq, windowFreq)) {

        // valid window found
    }
}
```
Permutation in String
Find All Anagrams in a String
Maximum Number of Vowels in a Substring of Given Length
Repeated DNA Sequences
Substring with Concatenation of All Words

## 4. Variable Sliding Window + Frequency Map Template
Used for:

longest substring\
shortest substring\
at most k\
exactly k

Examples:

Longest Substring with K Distinct\
Fruits Into Baskets\
Minimum Window Substring
```
Map<Character, Integer> map = new HashMap<>();

int i = 0;

for(int j = 0; j < s.length(); j++) {

    char ch = s.charAt(j);

    // add current character
    map.put(ch, map.getOrDefault(ch, 0) + 1);

    // shrink invalid window
    while(windowInvalid) {

        char left = s.charAt(i);

        map.put(left, map.get(left) - 1);

        if(map.get(left) == 0) {
            map.remove(left);
        }

        i++;
    }

    // update answer
}
```
