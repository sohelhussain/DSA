package algorithms.sorting;

/**
 * bubbleSort
 */
public class bubbleSort {

    public static void bubbleSortAlgo(int[] arr) {
        int n = arr.length;
        int temp;
        int i = 0;

        while (i < n - 1) {
            int j = 0;

            while (j < n - i - 1) {
                if (arr[j] > arr[j + 1]) { // Check if current element is greater than the next
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                j++;
            }

            i++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 5, 1, 4, 2 };

        bubbleSort(arr); // Call the sorting method

        // Print the sorted array
        int i = 0;
        while (i < arr.length) {
            System.out.println(arr[i]);
            i++;
        }
    }
}