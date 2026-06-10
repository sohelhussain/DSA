## use to calculate a bigger power like```2^1_000_000_00```

Binary Exponentiation (Fast Power)

Purpose:
Compute base^exp efficiently.

Idea:
- If exp is even:
    base^exp = (base^(exp/2))²

- If exp is odd:
    base^exp = (base^(exp/2))² × base

Bit Tricks:
- (exp & 1) == 1  -> exp is odd
- exp >>= 1       -> exp = exp / 2

Complexity:
- Time: O(log exp)
- Space:
    Recursive: O(log exp)
    Iterative: O(1)

Preferred Template:
while (exp > 0) {
    if ((exp & 1) == 1)
        result = (result * base) % MOD;

    base = (base * base) % MOD;
    exp >>= 1;
}

## code
<img width="585" height="443" alt="Screenshot 2026-06-10 at 9 15 24 AM" src="https://github.com/user-attachments/assets/cff4f291-5220-409d-8926-4cc9c8a8af89" />

```
private long findPower(long base, long exp) {
    if (exp == 0) return 1;

    long half = findPower(base, exp / 2);

    long result = (half * half) % MOD;

    if ((exp & 1) == 1) {
        result = (result * base) % MOD;
    }

    return result;
}
```
## Recommended
```
private long findPower(long base, long exp) {
    long result = 1;

    while (exp > 0) {
        if ((exp & 1) == 1) {
            result = (result * base) % MOD;
        }

        base = (base * base) % MOD;
        exp >>= 1;
    }

    return result;
}
```

## question

1. [Count Good Numbers](https://leetcode.com/problems/count-good-numbers/)
