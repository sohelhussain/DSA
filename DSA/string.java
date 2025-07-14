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
}
