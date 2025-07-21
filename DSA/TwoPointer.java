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
}
