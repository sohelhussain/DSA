# 1089. Duplicate Zeros [solve here]()
```
   public void write(int[]arr, int i, int j){
        if(j < arr.length){
            arr[j] = arr[i];
        }
    }
    public void duplicateZeros(int[] arr) {
        int zero = 0;

        for(int n: arr){
            if(n == 0){
             zero++;
            }
        }

        int i = arr.length - 1, j = (arr.length - 1) + zero;

        while(i != j){
            write(arr, i, j--);
            if(arr[i] == 0){
                write(arr, i, j--);
            }
            i--;
        }
    }
```
---
# 26. Remove Duplicates from Sorted Array [solve here]()
```
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;

        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j++];
            }else {
                j++;
            }
        }

        return i + 1;
    }
```
---

# 125. Valid Palindrome [solve here]()

```  
    public boolean isPalindrome(String str) {
        if(str.isEmpty()) return true;
        String s = str.toLowerCase();

        int i = 0;
        int j = s.length() - 1;

        while(i < j) {

            // Skip non-alphanumeric characters
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;


            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            
            i++;
            j--;
        }

        return true;
    }

```
---

# 167. Two Sum II - Input Array Is Sorted [solve here]()

```
  public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(i < j) {
            int sum = numbers[i] + numbers[j];

            if(sum == target) {
                return new int[]{i+1,j+ 1};
            }else if(sum < target) {
                i++;
            }else {
                j--;
            }
        }


        return new int[] {};
    }

```
---

# 189. Rotate Array [solve here]()

```
  class Solution {
    public void rotate(int[] nums, int k) { 
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n -1);
        reverse(nums, 0, k -1);
        reverse(nums, k, n -1);
    }

    public void reverse(int[] nums, int start, int end) {

        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```
---

# 18. 4Sum [solve here]()

```
  public List<List<Integer>> fourSum(int[] nums, int target) {
       Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int k = j + 1, l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;

                        // Skip duplicates
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }

        return list;
    }
```
---


# 881. Boats to Save People [solve here]()

```
  public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int boats = 0;

        while(i <= j) {
            int seating = people[i] + people[j];
            if(seating <= limit) {
                i++;
                j--;
            }else {
                j--;
            }
                boats++;
        }

        return boats;
    }
```
