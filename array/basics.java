import java.util.Scanner;

/**
 * Hello
 */
public class Hello {


    public static void main(String[] args) {
            //! isSorted or not in increaseing order
         int[] arr = {1,4,6,7,3,3};
        int n = arr.length;
        boolean isSorted = true;
        for(int i = 0; i < n - 1; i++){
            if (arr[i] > arr[i+1]){
                isSorted = false;
                break;
            } 
        }
        if(isSorted){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        //---------

        //! reverse array


        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int[] revers = new int[n];
        
        for(int i = 0; i < n; i++){
            revers[i] = arr[n - 1 - i];
        }
        
        for(int i = 0; i < n; i++){
            System.out.print(revers[i] + " ");
        }
        

    }
}
