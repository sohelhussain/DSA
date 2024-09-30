package DSA;

import java.util.ArrayList;
import java.util.List;

public class day33 {

    //!  Tower of Hanoi
    // play the game:- https://www.mathsisfun.com/games/towerofhanoi.html

    public static void towerOfHanoi(int n, int s, int h, int d){
        if(n==1){
            System.out.println(s + ' -> ' + d);
            return
        }
        towerOfHanoi(n-1, s, d, h);
        System.out.println(s + ' -> ' + d);
        towerOfHanoi(n-1, h, s, d);
    }


    //! power set

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

        //! Tower of Hanoi

        int n = 4;
        int s = 1, h = 2, d = 3;
        towerOfHanoi(n, s, h, d);


        //! power ka set for string 

//        String s = "abc";
//        List<String> ans = new ArrayList<>();
//        powerKaSet(s, 0, "", ans);
//        Collections.sort(ans);
//        System.out.println(ans);

       //! power ka set for int array

        // int arr[] = {1,2,3};
        // List<Integer> cur = new ArrayList<>();
        // List<List<Integer>> ans = new ArrayList<>();
        // powerKaSetArrayWala(arr, 0, cur, ans);
        // System.out.println(ans);
    }
}
