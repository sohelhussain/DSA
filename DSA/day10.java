import java.util.*;
import java.util.List;

public class Day10 {

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
