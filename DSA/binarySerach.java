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
}
