package DSA;

import java.util.Arrays;

/**
 * day15
 */
public class day15 {


//! 34. Find First and Last Position of Element in Sorted Array

    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int firstO = -1, lastO = -1;

        // Finding the first occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                firstO = mid;
                end = mid - 1;  // Continue searching to the left for the first occurrence
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Reset start and end for finding the last occurrence
        start = 0;
        end = nums.length - 1;

        // Finding the last occurrence
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                lastO = mid;
                start = mid + 1;  // Continue searching to the right for the last occurrence
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Returning an array of first and last occurrence
        return new int[] { firstO, lastO };
    }

    public static void main(String[] args) {

        //! 34. Find First and Last Position of Element in Sorted Array
        
        int[] nums = { 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 8, 8, 9 };
        int target = 2;
        int[] result = searchRange(nums, target);  // Fix the return type to int[]
        System.out.println(Arrays.toString(result));  // Use Arrays.toString() to print the result array
    }
}