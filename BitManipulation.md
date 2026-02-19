## how to convert Integer to Bit
```
public class Prac {
    public static String dfs(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            if(n % 2 == 1) sb.append('1');
            else sb.append('0');
            n /= 2;
        }
        return sb.reverse().insert(0, '1').toString();
    }
    public static void main(String[] args) {
        int n = 20;
        System.out.println(dfs(n));
    }
}
```
## how to convert Bit to Integer
```
public class Prac {
    public static int df(String n) {
        int len = n.length();
        int p2 = 1;
        int num = 0;
        for (int i = len - 1; i >= 0; i--) {
            if(n.charAt(i) == '1') num += p2;
            p2 = p2 * 2;
        }
        return num;
    }
    public static void main(String[] args) {
        System.out.println(df("10100"));
    }
}
```
 
