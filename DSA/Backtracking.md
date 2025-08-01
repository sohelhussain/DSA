### 1. Tower Of Hanoi.

-> First, we move n - 1 plates to the auxiliary rod.
(To do this, we can make the auxiliary rod the temporary destination for a shorter time.)

-> After this, we can move the n-th plate to the destination.


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
