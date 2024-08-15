package algorithms.searching;

public class binary {
    //! binary search
    public static int binarySearch(int[] num, int search){

        int left = 0;
        int right = num.length -1;

        while (left <= right) {
            int mid = (left + right) / 2; // m= 0 + 9 / 2 = 4
            if (num[mid] == search) {
                return mid;
            }
            else if (num[mid] < search) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int num[] = {1,4,5,14,24,26,27,100,121,156}; // i = 9
        int search = 100;
       int ans = binarySearch(num, search);
       System.out.println(ans);
    }
}
