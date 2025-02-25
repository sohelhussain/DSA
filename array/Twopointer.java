class Twopointer {
  public void main(args) {


    //! 1089. Duplicate Zeros
    if(j < arr.length){
            arr[j] = arr[i];
        }
    }
    public void duplicateZeros(int[] arr) {
        int zero = 0;

        for(int n: arr){
            if(n == 0){
             zero++;
            }
        }

        int i = arr.length - 1, j = (arr.length - 1) + zero;

        while(i != j){
            write(arr, i, j--);
            if(arr[i] == 0){
                write(arr, i, j--);
            }
            i--;
        }
  }
}
