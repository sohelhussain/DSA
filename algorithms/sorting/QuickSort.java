package algorithms.sorting;

public class QuickSort {

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Swap the pivot element to its correct position
        int temp = arr[i + 1]; 
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void quick(int arr[], int low, int high) {
        if (low < high) {
            int pidx = partition(arr, low, high);
            quick(arr, low, pidx - 1);
            quick(arr, pidx + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        quick(arr, 0, n - 1);

        // Print
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
