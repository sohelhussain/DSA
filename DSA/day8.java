package DSA;

//? Arrays Level 1 / Two Pointer

public class day8 {
    //! 485. Max Consecutive Ones
    public static int max(int[] x){
        int count = 0;
        int maxCount = 0;

        for(int i = 0; i < x.length; i++){
            if (x[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            }else{
                count = 0;
            }
        }
        return maxCount;
    }
    public static void main(String[] args) {
        int[] x = {1,1,0,1,1,1};
        System.out.println(max(x));
    }
}
