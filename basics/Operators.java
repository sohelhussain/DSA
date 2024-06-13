public class Operators {
    public static void main(String[] args) {



        // per-increment

        // int i = 10;    // we change the value of i ( i + 10 = 11, i = 11), the new value of i is 11
        // int j = ++i;   // we store the new value in j (that is a 11)
        // System.out.println(i); // 11
        // System.out.println(j); // 11



        // post-increment

        // int i = 10;  // first we store the value in a j variable that is 10
        // int j = i++; // secndoly we increment the value of i that is 11
        // System.out.println(i); // 11
        // System.out.println(j); // 10




        //✅ 1:-

        // int i = 11;
        // i = i++ + ++i;    
        // System.out.println(i);


        // sol:- 
        
        // i++ :- we store the value in i that is value is 11, then increment the value int i is 12
        // ++i :- know we know that we increment the value first the value is 12 + 1, 13
        // 11 + 13;




        //✅ 2:-

        // int a=11, b=22, c;
         
        // c = a + b + a++ + b++ + ++a + ++b;
         
        // System.out.println("a="+a);
        // System.out.println("b="+b);
        // System.out.println("c="+c);


        // sol:- 

        // a=13
        // b=24
        // c=103

        // Given, a=11, b=22
        // c = a + b + a++ + b++ + ++a + ++b
        // c = 11 + 22 + (a is used before increment) + (b is used before increment) + (a is used after increment) + (b is used after increment)
        // c = 11 + 22 + 11(a=12, b=22) + 22(a=12, b=23) + 13(a=13, b=23) + 24(a=13, b=24)
        // c = 11 + 22 + 11 + 22 + 13 + 24 = 103 and a=13, b=24



        //✅ 3:-


        // int i=0;
         
        // i = i++ - --i + ++i - i--;
         
        // System.out.println(i);




        // sol:- 


        // initially, i=0
        // i = i++ – –i + ++i – i–
        // i = (i is used before increment) – (i is used after decrement) + (i is used after increment) – (i is used before decrement)
        // i = 0(i=1) – 0(i=0) + 1(i=1) – 1(i=0)
        // i = 0 – 0 + 1 – 1 = 0



        //✅ 4:-


        // boolean b = true;
         
        // b++;
         
        // System.out.println(b);




        // sol:-

        // No. ++ or — can’t be applied to boolean types.





        //✅ 5:-

        // int i=1, j=2, k=3;
         
        // int m = i-- - j-- - k--;
         
        // System.out.println("i="+i);
        // System.out.println("j="+j);
        // System.out.println("k="+k);
        // System.out.println("m="+m);



        // sol:-

        // i=0
        // j=1
        // k=2
        // m=-4

        // Given, i=1, j=2, k=3
        // m = i– – j– – k–
        // m = (i is used before decrement) – (j is used before decrement) – (k is used before decrement)
        // m = 1(i=0) – 2(j=1) – 3(k=2)
        // m = 1 – 2 – 3
        // m = -4 and i=0, j=1, k=2




        //✅ 6:-

        // int a=1, b=2;
         
        // System.out.println(--b - ++a + ++b - --a);



        // sol:- 

        // Given, a=1 and b=2,
        // –b – ++a + ++b – –a
        // = (b is used after decrement) – (a is used after increment) + (b is used after increment) – (a is used after decrement)
        // = 1(a=1, b=1) – 2(a=2, b=1) + 2(a=2, b=2) – 1(a=1, b=2)
        // = 1 – 2 + 2 – 1 = 0


        //✅ 7:- 

        // int i=19, j=29, k;
         
        // k = i-- - i++ + --j - ++j + --i - j-- + ++i - j++;
         
        // System.out.println("i="+i);
        // System.out.println("j="+j);
        // System.out.println("k="+k);

        // sol:-

        // i=19
        // j=29
        // k=-20

        // Given, i=19 and j=29,
        // k = i– – i++ + –j – ++j + –i – j– + ++i – j++
        // k = (i is used before decrement) – (i is used before increment) + (j is used after decrement) – (j is used after increment) + (i is used after decrement) – (j is used before decrement) + (i is used after increment) – (j is used before increment)
        // k = 19(i=18, j=29) – 18(i=19, j=29) + 28(i=19, j=28) – 29(i=19, j=29) + 18(i=18, j=29) – 29(i=18, j=28) + 19(i=19, j=28) – 28(i=19, j=29)
        // k = 19 – 18 + 28 – 29 + 18 – 29 + 19 – 28
        // k = -20 and i=19, j=29


        //✅ 8:-

        // int i = 11;
         
        // int j = --(i++);

        // sol:-

        // Because, ++ or — can’t be nested [ –(i++) ]


        //✅ 9:- 

        // int m = 0, n = 0;
         
        // int p = --m * --n * n-- * m--;
         
        // System.out.println(p);


        // sol:-

        // Given, m=0 and n=0
        // p = –m * –n * n– * m–
        // p = (m is used after decrement) * (n is used after decrement) * (n is used before decrement) * (m is used before decrement)
        // p = -1(m=-1, n=0) * -1(m=-1, n=-1) * -1(m=-1, n=-2) * -1(m=-2, n=-2)
        // p = -1 * -1 * -1 * -1 = 1


        //✅ 10:- 

        // int a=1;
         
        // a = a++ + ++a * --a - a--;
         
        // System.out.println(a);

        // Given a=1,
        // a = a++ + ++a * –a – a–
        // a = (a is used before increment) + (a is used after increment) * (a is used after decrement) – (a is used before decrement)
        // a = 1(a=2) + 3(a = 3) * 2(a=2) – 2(a=1)
        // a = 1 + 3 * 2 – 2
        // a = 1 + 6 – 2 = 5

    }
}
