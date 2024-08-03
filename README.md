Day 1	--Complexity Basics
			--Complexities are generally calculated for LARGE inputs
		--Cases
			--Best Case < Avg Case < Worst Case
		--Time Complexity
			--It is not the time taken by an algorithm to execute
			--It is the number of steps taken by an alogo to execute
			--This is a function which represents the growth of time as the input grows
		--Generating complexity equations
			--Ignore the less dominating terms and constants
				--They are irrelevent for LARGE inputs
		--Complexity Representation
			--Big Oh - O(N) - Upper bound - Algo will never exceed N steps
			--Big Omega - Ω(N) - Lower bound - Algo will take at least N steps
			--Theta - θ(N) - Lower & Upper Bound - Algo will take exactly N steps 
		--Time complexity graph
			O(1) < O(log N) < O(N) < O(N log N) < O(N^2) < O(2^N) < O(N!)
			constant < log < linear < quadratic < exponential < factorial
		--TimeLimitExceeded
			--Machine can perform 10^8 op / second
			--Understanding Constraints
			--which algo to apply ?
			--Graphic
		--Space Complexity
			--Memory consumed by inputs + Auxiliary Space
			--local variabls do not count as extra space

Day 2	--Stack Memory
			--Fast access, Small size
			--Stack data structure, push and pop features
			--holds active functions and local variables
		--How function get called ?
			--Stack diagram
		--What exactly the return statement is ?
		--Heap Memory
			--Large in size
			--may become fragmented
			--stores objects

		--Recursion
			--Process by which a problem depends on solutions to smaller instances of same problem
			--Problem keeps on breaking untill the base case hits
			--Uses extra space for recursive calls
			--Recursive leap of faith
			--Reccurance relation

		--Base case
			--Think of the smallest input possible for the problem statement

Day 3	--Recursion Level 1 
			P1. Print hello n times
			P2. Print natural numbers 1-n
			P3. Print natural numbers n-1
			P4. Sum of first n natural numbers
			P5. factorial
			P6. Sum of digits of a number
			P7. Fibonacci Numbers
				--Recursion Tree	
			P8. GCD or HCF of two numbers
				--BF - O(min(a, b))
	
Day 4	--Maths Level 1
			P9. Count digits of a number
				(int) Math.log10(n) + 1
			P10. 9. Palindrome Number
			P11. 7. Reverse Integer
			P12. 258. Add Digits
			P13. Factors of number
				--BF - O(n)
				--Reduced it to O(sqrt(n))
			P14. Prime number
				--General Formula - 6n + 1 or 6n - 1 except n = 2, 3
				--Program 
					--check till Math.sqrt(n)
					--complexity O(sqrt(n))

Day 5	--Maths Level 2
			P15. 204. Count Primes
				--Sieve of Eratosthenes
				--complexity O(n log(log(n))
			P16. 1492. The kth Factor of n
			P17. GCD 
				--Euclidean Algo
					gcd(a, b) = gcd(a-b, b), b<a
					O(log(min(a,b))
			P18. 1979. Find Greatest Common Divisor of Array
			P19. LCM
				--Euclidean Formula
					a*b / gcd(a, b);

Day 6	--Maths Level 3
			P20. 69. Sqrt(x)
				--BF method
					O(sqrt(n))
				--Integer overflow problem
			P21. 50. Pow(x, n)
				--BF - O(b)
				--Optimized - O(log(n))
					if b is even then pow(a, b/2) * pow(a, b/2)
					if b is odd then pow(a, b/2) * pow(a, b/2) * a
			P22. 231. Power of Two