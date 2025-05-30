public class Math {

  // any value that properly divede by 100 that is called perfect Sqre = 100 % 2 = 0 
  public static void perfectSqur(String[] args) {
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
}
