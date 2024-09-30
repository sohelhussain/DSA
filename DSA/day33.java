package DSA;

import java.util.ArrayList;
import java.util.List;

public class day33 {
    public static void powerKaSet(String s, int i, String cur, List<String> ans) {
        if(i == s.length()) {
            if(cur.length() > 0)
                ans.add(cur);
            return;
        }
        //le liya
        powerKaSet(s, i+1, cur + s.charAt(i), ans);

        //nahi liya
        powerKaSet(s, i+1, cur, ans);
    }
    private static void powerKaSetArrayWala(int[] arr, int i, List<Integer> cur, List<List<Integer>> ans) {
        if(i == arr.length) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(arr[i]);
        //pick
        powerKaSetArrayWala(arr, i+1, cur, ans);
        cur.removeLast();
        //not pick
        powerKaSetArrayWala(arr, i+1, cur, ans);
    }
    public static void main(String[] args) {
//        String s = "abc";
//        List<String> ans = new ArrayList<>();
//        powerKaSet(s, 0, "", ans);
//        Collections.sort(ans);
//        System.out.println(ans);
        int arr[] = {1,2,3};
        List<Integer> cur = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        powerKaSetArrayWala(arr, 0, cur, ans);
        System.out.println(ans);
    }
}
