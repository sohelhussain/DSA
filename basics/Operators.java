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


        //✅ 1:-

        // int i = 11;
        // i = i-- + --i;    
        // System.out.println(i);
    }
}
