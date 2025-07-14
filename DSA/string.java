class Solution {

  // 67. add binary
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder sb = new StringBuilder();

        int carry = 0;

        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) sum += Character.getNumericValue(a.charAt(i));
            if(j >= 0) sum += Character.getNumericValue(b.charAt(j));

            sb.append(sum % 2);
            carry = sum / 2;

            i--;
            j--;
        }

        if(carry == 1) sb.append(1);

        return sb.reverse().toString();
    }



  // 796. Rotate String
  public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        StringBuilder sb = new StringBuilder(s);

        int n = s.length();

        while(n-- > 0) {
            if(sb.toString().equals(goal)) return true;
            char ch = sb.charAt(0);
            sb.append(ch);
            sb.deleteCharAt(0);
        }

        return false;
    }



  //14. Longest Common Prefix

  public String check(String str1, String str2) {

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        while(i < str1.length() && j < str2.length()) {
            if(str1.charAt(i) == str2.charAt(j)){
                sb.append(str1.charAt(i));
            } else {
                break;
            }
            i++;
            j++;
        }

        return sb.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String s = strs[0];

        for(int i = 1; i < strs.length; i++) {
            s = check(strs[i], s);
        }

        return s;
    }
}
