import java.util.*;
import java.util.List;

public class Day10 {
    // 3 sum brut force
    public List<List<Integer>> threeSum(int[] nums) {
        List <int[]> list = new ArrayList<>();

    for(int i = 0; i < nums.length; i++) {
        for(int j = i + 1; j < nums.length; j++){
            for(int k = j + 1; k < nums.length; k++){
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(new int[]{nums[i], nums[j], nums[k]});
                }
            }
        }
    }

    return list; // <- this is worng.
    }


    // optimum approch
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

       Arrays.sort(nums);

       for(int i = 0; i < nums.length -2; i++){
        if (i != 0 && nums[i] == nums[i - 1]) {
            continue;
        }
        int j = i + 1, k = nums.length - 1;
        while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                while (j < k && nums[j] == nums[j - 1]) {
                    j++;
                }
                while (j < k && nums[k] == nums[k + 1]) {
                    k--;
                }
            }else if (sum < 0) {
                j++;
            }else{
                k--;
            }
        }
       }

       return ans;
    }


    // 56 merge intervals

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        for(int[] interval: intervals){
            int size = list.size();
            if (size == 0 || list.get(size-1)[1] < interval[0]) {
                list.add(interval);
            }else{
                list.get(size -1)[1] = Math.max(list.get(size -1)[1], interval[1]);
            }
        }

        int[][] ans = new int[list.size()][];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        };

        return ans;
    }

    public static void main(String[] args) {


        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18} };

        int[][] ans = merge(intervals);

        for(int[] a: ans){
            for(int b: a){
                System.out.println(b);
            }
        }
    }
}
