package DSA;

public class day9 {
    // ! 724. Find Pivot Index
    public static int Pivot(int[] nums){
        int[] newArr = new int[nums.length];
        int sum = nums[0];
        newArr[0] = 0;
        int calc = 0;

        for(int i = 1; i < nums.length; i++){
            sum += nums[i];
            newArr[i] = nums[i - 1] + newArr[i - 1];
        }
        for(int i = 0; i < nums.length; i++){
            calc = sum - nums[i] - newArr[i];
            if (newArr[i] == calc) {
                return i;
            }
        }
        return -1;
            
    }

    // ! Product of Array Except Self

    public static void Product(int[] nums){
        int[] nums = { 1, 2, 3, 4 };
        // int[] left = {1,1,2,6};
        int[] left = new int[nums.length];

        left[0] = 1;
        for (int i = 1; i < nums.length ; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        int right = 1;

        int[] ans = new int[nums.length];

        for (int i = left.length - 1; i >= 0; i--) {
            ans[i] = right * left[i];
            right *= nums[i];
        }

        for(int i: ans){
            System.err.println(i);
        }
        for(int i: left){
            System.err.println(i);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(Pivot(nums));
    }
}
