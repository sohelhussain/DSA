/**
 * genrelRecursion
 */
public class genrelRecursion {

    // ------genrel calling--------------------------------

    // public static void m1(){
    // System.out.println('1');
    // m2();
    // }
    // public static void m2(){
    // System.out.println('2');
    // m3();
    // }
    // public static void m3(){
    // System.out.println('3');
    // m4();
    // }
    // public static void m4(){
    // System.out.println('4');
    // }

    // public static void main(String[] args) {
    // m1();
    // int i = 3;
    // System.out.println(i);
    // }

    // ----------------genral recursion--------------------------------

    public static void gen(int n){
        System.out.println(n);
        if (n == 1) {
            return
        };
        gen(n-1);
    };

    public static void main(String[] args) {
        gen(5);
    };
}