package DSA;

//! recursion

public class day3 {

    public static void prn(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        prn(n - 1);
    }
    public static int sum(int n) {
        if (n == 1) {
            return 1; 
        }
        return n + sum(n - 1);
    }
    public static void main(String[] args) {
        // prn(5);
        // System.out.println(sum(5));
        
    }
}
