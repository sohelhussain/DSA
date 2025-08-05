# element swap in array.

```
int[] nums = {1,2,3,4,5};

int temp = nums[0];          [1,2,3,4,5];
nums[0] = nums[4];           [5,2,3,4,5];
nums[4] = temp;              [5,2,3,4,1];
```

---

# cyclic array
```
int[] nums = {1,2,3,4,5};
int n = nums.length; // n == 5
```

```
0 % n = 0
1 % n = 1
2 % n = 2
3 % n = 3
4 % n = 4
```
```
5 % n = 0
6 % n = 1
7 % n = 2
8 % n = 3
so own...
```
