# 1. Tower Of Hanoi.

1. First, we move n - 1 plates to the auxiliary rod.
(To do this, we can make the auxiliary rod the temporary destination for a shorter time.)

2. After this, we can move the n-th plate to the destination.


```
public static void towerOfHanoi(int s, int aux, int d, int n){
        if(n==1){
            System.out.println(s + ' -> ' + d);
            return
        }
        //n - 1 plates are gose source to aux.
        towerOfHanoi(s, d, aux, n - 1);
        System.out.println(s + ' -> ' + d);
        towerOfHanoi(aux, s, d, n - 1);
    }

public static void main(String[] args) {
        int n = 3; // plates
        tow(1, 2, 3, n);
    }
```

![towerofhanoi](https://github.com/user-attachments/assets/b91896d3-b2d2-4ae2-b7c0-3fb79d79363d)

---

# 1823. Find the Winner of the Circular Game.

1. We create a circular ArrayList and find the index of the person to be eliminated using the formula:
(i + k - 1) % size, where i is the current index, k is the step count, and size is the number of remaining people.

**why we're using this formula** => [Learn more](https://github.com/sohelhussain/DSA/blob/main/why.md#scenario-josephus-problem)

```
class Solution {
    private int alive(List<Integer> people, int i, int k) {
        if(people.size() == 1) return people.get(0);
        int killPerson = (i + k - 1) % people.size();
        people.remove(killPerson);
       return alive(people, killPerson, k);
    }

    public int findTheWinner(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        return alive(list, 0, k);
    }
}

```

![circular array](https://github.com/user-attachments/assets/0c965ea0-f0ca-415d-be8b-b74145e5917c)


---

# Subset powerset **Imp.**


### 1. powerSet
```
class Solution {
public static void subsetString(String s, String cur, List<String> ans, int i) {
    if(i == s.length()) {
        if (cur.length() > 0) {
            ans.add(cur);
        }
        return;
    }

    //choose
    subsetString(s, cur + s.charAt(i), ans, i + 1);
    
    // not choose
    subsetString(s, cur, ans, i + 1);
  } 

    public static void main(String[] args) {
        String s = "abc";
        List<String> ans = new ArrayList<>();
        subsetString(s, "", ans, 0);
        Collections.sort(ans);
        System.out.println(ans);
    }
}
```
