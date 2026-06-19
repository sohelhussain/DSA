

```
int bestEnding = nums[0];
int res = nums[0];

for(int i = 1; i < nums.length; i++) {
    int v1 = bestEnding + nums[i];
    int v2 = nums[i];

    bestEnding = Math.max(v1, v2);
    res = Math.max(bestEnding, res);
}
```
