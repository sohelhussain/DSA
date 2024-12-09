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





        //factotrial of sum

        int n = 145;
        int factSum = 0;
        while( n != 0){
            int lastdigit = n % 10;
            int fact = 1;
            for(int i = 1; i <= lastdigit; i++){
                fact = fact * i;
            }
            factSum = factSum + fact;
            n = n / 10;
        }
        System.out.println(factSum);    







        // calculat auto mofic and count of digit

       int number = 25;
       int count = 0;
       int temp = number;

       while (number != 0) {
        count++;
        number = number / 10;
       }

       number = temp;
       long sq = number * number;
       long lastdigit = sq % (long) Math.pow(10, count);
       System.out.println(number == lastdigit ? "auto morfic" : "non auto morfic");




        //giv single digits

        
              int n = 14398;
      while (n > 9) {
          int sum = 0; 
          while (n != 0) {
           int last = n % 10;
           sum = sum + last;
           n = n / 10;  
          }
          n = sum;
      }
      System.out.println(n);
    }
}
