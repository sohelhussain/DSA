public class DomiMergsort {
  public static void twoSpace(int[] arr, int mid, int right, int left){
        int n = mid - left + 1;
        int m = right - mid;


        int[] arr1 = new int[n];
        int[] arr2 = new int[m];


        for(int i = 0; i < n; i++){
            arr1[i] = arr[left + i];
        }

        for(int i = 0; i < m; i++){
            arr2[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

       while (i < n && j < m) {
        if (arr1[i] <= arr2[j]) {
            arr[k++] = arr1[i++];
        }else {
            arr[k++] = arr2[j++];
        }
       }

       while (i < n) {
        arr[k++] = arr1[i++];
       }
       while (j < m) {
        arr[k++] = arr2[j++];
       }
    }
   
    public static void oneSpace(int[] arr, int left, int mid, int right){

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            }else{
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= mid) {
            temp[k++] = arr[j++];
        }

        for(i = left; i < right; i++){
            arr[i] = temp[i - left];
        }
    }



    public static void withoutSpace(int[] arr, int left, int mid, int right){
        int i = left, j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            }else {
                int idx = j;
                int temp = arr[j];

                while (idx != i) {
                    arr[idx] = arr[idx - 1];
                    idx--;
                }
                arr[idx] = temp;

                i++;
                j++;
                mid++;
            }
        }
    }

    public static void merge(int[] arr, int left, int right){
        if (left < right) {
            int mid = (left + right) / 2;
            merge(arr, left, mid);
            merge(arr, mid, right);
            withoutSpace(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {

        int[] arr = {2,4,7,9,12,1,3,4,6,7,10};
        int left = 0;
        int right = arr.length;
        merge(arr, left, right);

    }
}
