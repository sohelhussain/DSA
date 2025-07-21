class Solution {

  
  // 125. Valid Palindrome

  
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



  // 167. Two Sum II - Input Array Is Sorted


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



  // 189. Rotate Array




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







  
}
