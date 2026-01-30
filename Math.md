# gcd by recursion
formula
```
gcd(a, b) = gcd(b, a % b)
When b == 0 → answer = a
```
```
static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```
itretive
```
static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
```
---
# lcm
formula
```
LCM(a, b) = (a * b) / GCD(a, b)
```
```
static int lcm(int a, int b) {
    return (a / gcd(a, b)) * b; // prevents overflow
}
```
# gcd by array
```
arr = [12, 18, 24]
GCD = 6


static int gcdArray(int[] arr) {
    int result = arr[0];
    for (int i = 1; i < arr.length; i++) {
        result = gcd(result, arr[i]);
        if (result == 1) return 1; // early stop
    }
    return result;
}

```
# Count digits
```
int count = 0;
int n = num;
while (n > 0) {
    count++;
    n /= 10;
}
```
# reverse digit
```
int rev = 0;
while (n > 0) {
    rev = rev * 10 + n % 10;
    n /= 10;
}
```
# prime number
```
static boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```
# count tailering zero
```
Input: 100
Output: 24


static int trailingZeroes(int n) {
    int count = 0;
    while (n > 0) {
        n /= 5;
        count += n;
    }
    return count;
}
```
