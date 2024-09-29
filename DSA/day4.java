package DSA;

//? MATH LEVEL 1
public class day4 {
    // ! 1. Count digits of a number
    // public static void countNum(int n, int Count){
    // if (n==0) {
    // return;
    // }
    // System.out.println(Count);
    // countNum(n/10, ++Count);
    // }

    // ! 2. Palindrome Number

    // public static boolean isPalindrome(int n) {
    // if (n<0) {
    // return false;
    // }
    // long reverse = 0;
    // long temp = n;
    // while (temp != 0) {
    // int digits = (int) (temp % 10);
    // System.out.print(digits );
    // reverse = reverse * 10 + digits;
    // temp /= 10;
    // }
    // return(reverse == n);
    // }

    // ! 3. Reverse Integer

    // public static int isReverse(int n) {
    // int reverse = 0;
    // while (n != 0) {
    // int digits = n % 10;
    // if (reverse>Integer.MAX_VALUE/10 || reverse<Integer.MIN_VALUE/10) {
    // return 0;
    // }
    // reverse = reverse * 10 + digits;
    // n = n/10;
    // }
    // return reverse;
    // }

    // ! 4. Add Digits

    public static int addDigits(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 9 == 0) ? 9 : n % 9;

    }
    public static void main(String[] args) {
        // countNum(3424357, 1);

        // System.out.println(isPalindrome(22));

        // System.out.println(isReverse(123));

        System.out.println(addDigits(39));

    }
}
