public class Math {

  public static void perfectSqur(String[] args) {
  // find factorial any value that properly divide by 100 that is called perfect Square = 100 % 2 = 0 
       int n = 100;
       List<Integer> list = new ArrayList<>();
       for(int i = 1; i <= Math.sqrt(n); i++){
        if (n%i == 0) {
            list.add(i);
        }
       }

       for(int i = (int)Math.sqrt(n); i >= 1; i--){
        if (n%i == 0) {
            if (i * i != n) {
                    list.add(n/i);
            }
        }
       }
       System.out.println(list);
    }


   public static boolean isPrime(int n){
        // prime number is number that divided by 1 or only divided by onw = 11 % 1 = 0, 11 % 11 = 0;
        if (n <= 1) {
            // return false;
        }
        if (n <= 3) {
            // return true;
        }
        if(n % 2 == 0 || n % 3 == 0){
            // return false;
        }
        for(int i = 5; i < Math.sqrt(n); i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

  // countPrime with optimal aproch
   public static void countPrime(int n){

    boolean prime[] = new boolean[n+1];
    Arrays.fill(prime,true);
    prime[0] = prime[1] = false;

    for(int i = 2; i * i <= n; i++){
        if (prime[i]) {
            for(int j = i *i; j <= n; j = j+i){
                prime[j] = false;
            }
        }
    }

    for(int i = 0; i <= n; i++){
        if (prime[i]) {
            System.out.println(i);
        }
    }

   }

}
