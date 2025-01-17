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

        

    }
}
