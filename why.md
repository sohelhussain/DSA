
# Scenario: Josephus Problem

a visual example to understand why i + k - 1 is used in circular elimination.

You have 5 people standing in a circle:

```
Index:     0   1   2   3   4
Person:   A   B   C   D   E
You start from index i = 0 (person A), and want to eliminate every 3rd person (k = 3)
```
## Step-by-step count
You are currently at index 0 (A).

Now count 3 people starting from A:

1 → A (index 0)

2 → B (index 1)

3 → C (index 2) ← ❌ Eliminate this one

✅ So, person C (index 2) is eliminated.

💡 Formula Used: (i + k - 1) % size
Let’s plug it in:

i = 0 (current index)

k = 3 (step count)

size = 5 (number of people)

```
(i + k - 1) % size
= (0 + 3 - 1) % 5
= 2 % 5
= 2
👉 Result: Index 2, which matches person C — correct!
```

📉 Without -1, see what happens:
If you mistakenly use:
```
(i + k) % size = (0 + 3) % 5 = 3
```

You'd eliminate person D (index 3) instead of C — ❌ Incorrect.

🔁 Visual Loop Summary:
Let’s try one more round (after person C is gone):

New circle (after removing C):

```
Index:     0   1   2   3
Person:   A   B   D   E
           ↑
          i = 2 (we continue from person after C, which is D)
Apply formula again:

i = 2

k = 3

size = 4
```

```
(i + k - 1) % size = (2 + 3 - 1) % 4 = 4 % 4 = 0
✅ Eliminate index 0 → person A
```

## Conclusion
we use **i + k - 1** because:

we're counting starting from the current person.

The -1 adjusts for inclusive counting.

