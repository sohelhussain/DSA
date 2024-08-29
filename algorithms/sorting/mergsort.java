package algorithms.sorting;

/**
 * mergsort
 */
public class mergsort {

    // Function to merge two halves of the array
    public static void conquer(int arr[], int si, int mid, int ei) {
        int merged[] = new int[ei - si + 1]; // Array to hold merged elements

        int idx1 = si;       // Start index for the left subarray
        int idx2 = mid + 1;  // Start index for the right subarray
        int x = 0;           // Index for the merged array

        // Merge the two sorted halves into the merged array
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] <= arr[idx2]) {
                merged[x++] = arr[idx1++];  // Add from left subarray
            } else {
                merged[x++] = arr[idx2++];  // Add from right subarray
            }
        }

        // Copy any remaining elements from the left subarray
        while (idx1 <= mid) {
            merged[x++] = arr[idx1++];
        }

        // Copy any remaining elements from the right subarray
        while (idx2 <= ei) {
            merged[x++] = arr[idx2++];
        }

        // Copy the merged array back to the original array
        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    // Function to divide the array into halves
    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) { // Base case: if the array has 1 or 0 elements
            return;
        }

        int mid = si + (ei - si) / 2;  // Find the middle point

        // Recursively divide the left half
        divide(arr, si, mid);

        // Recursively divide the right half
        divide(arr, mid + 1, ei);

        // Merge the sorted halves
        conquer(arr, si, mid, ei);
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8}; // Input array
        int n = arr.length;

        // Start the divide process
        divide(arr, 0, n - 1);

        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}