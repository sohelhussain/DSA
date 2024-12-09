public class Digits {
    public static void main(String[] args) {
      // revers the number
      int n = 5678;
      int rev = 0;
      
      while (n != 0) {
        // extract the last digits from the number
        int lastdigit = n % 10;
        // making the space in rev by the help of muliply by 10 and add lastdigit
        rev = rev * 10 + lastdigit;
        // remove the lastdigit in numbers
        n = n / 10;
      }
      System.out.println(rev);






        // chaick is palindrome or not

        int num = 121;
        int revers = 0;
        int temper = num;
        while (num != 0) {
            int lastdigit = num % 10;
            revers = revers * 10 + lastdigit;
            num = num / 10;
        }
        num = temper;
        System.out.println(num == revers ? "palindrome": "is Not palindrome");
    }
}
