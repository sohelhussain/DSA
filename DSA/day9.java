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

    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(Pivot(nums));
    }
}