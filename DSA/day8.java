package DSA;

//? Arrays Level 1 / Two Pointer

public class day8 {
    // ! 485. Max Consecutive Ones
    public static int max(int[] x) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    // ! 88.Merge Sorted Array

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && num1[i] > num2[j]) {
                num1[k] = num2[i];
                k--;
                i--;
            } else {
                num1[k] = num2[j];
                k--;
                j--;
            }
        }
    }

    // ! 941. Valid Mountain Array

    public static boolean Mountain(int[] A) {
        int n = A.length, i = 0, j = n - 1;
        while (i + 1 < n && A[i] < A[i + 1]) {
            i++;
        }
        while (j > 0 && A[j - 1] > A[j]) {
            j--;
        }
        return i > 0 && i == j && j < n - 1;
    }

    // ! 26. Remove Duplicates from Sorted Array

    public static int RemoveDuplicates(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
            i++;
        }
        return ++j;
    }

    public static void main(String[] args) {

        // ? 485. Max Consecutive Ones

        // int[] x = {1,1,0,1,1,1};
        // System.out.println(max(x));

        // ? 88.Merge Sorted Array

        // int[] num1 = { 1, 2, 3, 0, 0, 0 };
        // int m = 3;
        // int[] num2 = { 2, 5, 6 };
        // int n = 3;
        // merge(num1, m, num2, n);
        // for (int i = 0; i < num1.length; i++) {
        // System.out.println(num1[i]);
        // }

        // ? 941. Valid Mountain Array

        // int[] A = { 0, 2, 3, 4, 5, 2, 1, 0 };
        // System.out.println(Mountain(A));

        // ? 26. Remove Duplicates from Sorted Array

        int[] nums = { 1, 2, 2,2,4,4,5 };
        System.out.println(RemoveDuplicates(nums));

    }
}
