public class binarySearch {

  public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length - 1;
        while(start < end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < arr[mid + 1]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }

        return start;
    }

  
  public static void findFirstPositionAndLast() {

       int[] nums = {5,7,7,8,8,10};
       int target = 8;
       int start = 0, end = nums.length - 1;

        int firts0 = -1, last0 = -1;
       while (start <= end) {
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            firts0 = mid;
            end = mid - 1;
        }else if (target < nums[mid]) {
            end = mid - 1;

        }else {
            start = mid + 1;

        }
       }

       start = 0;
       end = nums.length - 1;

       while (start <= end) {
        int mid = start + (end - start) / 2;
        if (target == nums[mid]) {
            last0 = mid;
            start = mid + 1;
        }else if (target < nums[mid]) {
            end = mid - 1;

        }else {
            start = mid + 1;

        }
       }
       System.out.println(firts0);
       System.out.println(last0);
    }
  
  // 33. Search in Rotated Sorted Array
  public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[start] <= nums[mid]){
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(nums[mid] < target && target <= nums[end]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return -1;
    }


  // 4. Median of Two Sorted Arrays
  public double findMedianSortedArrays() {

    int[] nums1 = {1,3,9,11,15};   
      int[] nums2 = {2,4,7,20,29,45}; 
    
        if(nums1.length > nums2.length){
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
      int n = nums2.length;

      int start = 0, end = m;

      while (start <= end) {
        int mid1 = start + (end - start) / 2;
        int mid2 = (m + n + 1) / 2 - mid1;

        int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1 - 1];
        int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];

        int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2 - 1];
        int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

        if (l1 <= r2 && l2 <= r1) {
            if((m + n) % 2 == 0){ // even
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }else{
                return Math.max(l1, l2);
            }
        }
        if (l2 > r1) {
            start = mid1 + 1;
        }else{
            end = mid1 - 1;
        }
      }
      return 0.0; 
    }
}
