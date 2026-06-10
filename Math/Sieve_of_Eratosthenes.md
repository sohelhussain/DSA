# Sieve of Eratosthenes Notes

## Problem

Count the number of prime numbers less than `n`.

A prime number is a number greater than 1 that has exactly two factors:

* 1
* Itself

Examples:

* Prime: 2, 3, 5, 7, 11
* Not Prime: 4, 6, 8, 9, 10

---

## Brute Force Approach

For every number from `2` to `n - 1`:

1. Check if it is prime.
2. Increment count if prime.

### Prime Check

```java
private boolean isPrime(int n) {
    if (n <= 1) return false;

    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }

    return true;
}
```

### Complexity

* Prime Check: O(√n)
* Total: O(n√n)

Not efficient for large values of `n`.

---

# Sieve of Eratosthenes

## Core Idea

Instead of checking each number individually:

1. Assume every number is prime.
2. Start from 2.
3. Mark all multiples of 2 as non-prime.
4. Move to the next unmarked number.
5. Mark all its multiples.
6. Continue until `i * i >= n`.

The remaining unmarked numbers are prime.

---

## Why Start from i²?

Suppose `i = 5`.

Multiples:

```text
5 × 2 = 10
5 × 3 = 15
5 × 4 = 20
5 × 5 = 25
```

10, 15, and 20 have already been marked by smaller primes (2 and 3).

Therefore, start directly from:

```text
5 × 5 = 25
```

General rule:

```java
for (int j = i * i; j < n; j += i)
```

---

## Why Loop Until i * i < n?

If a number has a factor greater than √n, then it must also have a factor smaller than √n.

Therefore, checking beyond √n is unnecessary.

Condition:

```java
for (int i = 2; i * i < n; i++)
```

---

## LeetCode 204 Important Point

The problem asks for:

```text
Prime numbers less than n
```

NOT:

```text
Prime numbers less than or equal to n
```

Examples:

```text
n = 2
Primes < 2 = {}
Answer = 0
```

```text
n = 3
Primes < 3 = {2}
Answer = 1
```

```text
n = 10
Primes < 10 = {2,3,5,7}
Answer = 4
```

---

## Correct Sieve Implementation

```java
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }
}
```

---

## Dry Run (n = 10)

Initial:

```text
2 3 4 5 6 7 8 9
T T T T T T T T
```

After processing 2:

```text
2 3 4 5 6 7 8 9
T T F T F T F T
```

After processing 3:

```text
2 3 4 5 6 7 8 9
T T F T F T F F
```

Remaining primes:

```text
2, 3, 5, 7
```

Count = 4

---

## Complexity

### Time

```text
O(n log log n)
```

### Space

```text
O(n)
```

---

## Interview Takeaways

1. Prime check can be optimized to O(√n).
2. Sieve marks multiples instead of checking every number.
3. Start marking from `i * i`.
4. Stop outer loop at `i * i < n`.
5. For LeetCode 204, count primes in the range:

```text
[2, n)
```

not

```text
[2, n]
```
