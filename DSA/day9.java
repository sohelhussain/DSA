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

    // 53 maximum subArray

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];                // <- we store a initial value becuse question give a minimum one value 
        int curSum = 0;
        for(int num: nums){
            curSum += num;
            maxSum = Math.max(maxSum, curSum);
            if(curSum < 0){                  // --Kadane's Algo when you see the negetive element then you do current sum is zero
                curSum = 0;
            }
        }

        return maxSum;
    }


   // P40. 169. Majority Element
				// --Moore's Voting Algo

    public int majorityElement(int[] nums) {
        int probably = nums[0];
        int voting = 1;

        for (int num : nums) {
            if (num == probably) {
                voting++;
            } else {
                voting--;
            }
            if (voting == 0) {
                probably = num;
                voting = 1;
            }
        }

        // confermation code
        
        int count = 0;
        for(int num: nums){
            if (num == probably) {
                count++;
            }
        }

        if (count >= (nums.length / 2) + 1) {            
            return probably;
        }
        return probably;
    }
    
    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(Pivot(nums));
    }
}
