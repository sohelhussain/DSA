https://www.codechef.com/roadmap/data-structures-and-algorithms

<h1>DSA SHEET</h1>

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
Day 7	--Array & ArrayList
			--dynamic Size Arrays i.e. ArrayList
			
			P23. Largest / Second largest element in array
			P24. 344. Reverse String
			P25. Left Rotation by K elements
				--in O(n) time & O(n) space
				--in O(1) space using swap algo
			P26. 189. Rotate Array
			
Day 8	--Arrays Level 1 / Two Pointer

			P27. 485. Max Consecutive Ones
			P28. 88. Merge Sorted Array
			P29. 941. Valid Mountain Array
			P30. 26. Remove Duplicates from Sorted Array
			P31. 1089. Duplicate Zeros
		
			P33. 977. Squares of a Sorted Array
			P34. 283. Move Zeroes
			

Day 9	--Arrays Level 2 / Prefix Sum

			P37. 724. Find Pivot Index
			P38. 238. Product of Array Except Self
			P39. 53. Maximum Subarray 
					--Kadane's Algo
			P40. 169. Majority Element
					--Moore's Voting Algo
			P41. 121. Best Time to Buy and Sell Stock
			
		

Day 10		P43. 42. Trapping Rain Water
			P44. 11. Container With Most Water
			
			
Day 11	--Sorting Algorithms	
			--Stability
				--Stable - Bubble, Insertion, Merge
				--Unstable - Selection, Quick, Heap
			--Bubble Sort
				--O(N^2)
				--Compare with the adjacent element
				--Optimization
			--Selection Sort
				--O(N^2)	
				--Select the largest/smallest element, put at its place
			--Insertion Sort
				--O(N^2)
				--Pick the next element and insert at it correct place in the sorted array.

Day 12	--Merge Sort
			--O(N log N), O(N) space
			--Divide and Conquer based algo
			
			P46. 912. Sort an Array
			P47. 75. Sort Colors
			
Day 13	--Quick Sort
			--O(N log N) - Best case
			--O(N ^ 2) - Worst Case
			--Intuition
				--Choose any element as pivot and place it at its rightfull position
				--All the elements to the left of pivot are smaller than pivot	
				--All the elements to the right of pivot are larger than pivot
				--Repeat the process on two subarrays (right & left) 

		--Cyclic Sort
			--Identification - 1 to N range
			--Negate Technique
				--Mark the element negate to keep the visted tracking
				--Will work only with positive range
			P48. 268. Missing Number
			P49. 448. Find All Numbers Disappeared in an Array
			
Day 14		P50. 442. Find All Duplicates in an Array
			
		P52. 41. First Missing Positive

Day 15	--Binary Search
			--Identification 
				--Sorted data
				--Range of Numbers
			--Algo & Code
				--O(log N)
				--Iterative
				--Recursive

		--Binary Search Level 1
			P53. 704. Binary Search
			P54. 35.Search Insert Position
			P55. 367. Valid Perfect Square
			
			P57. 34. Find First and Last Position of Element in Sorted Array		

Day 16	--Binary Search Level 2
			P58. 852. Peak Index in a Mountain Array
			P59. 153. Find Minimum in Rotated Sorted Array
			P60. 33. Search in Rotated Sorted Array
			
			

Day 19	--Binary Search Level 3
			P63. Book allocation problem B.Q.
					https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
				--Problem - Minimize the maximum number of pages read by a student
				--Restrictions
					--Every student must read at least one book
					--Two students can not read a same book
					--Allot books in continous manner
			P64. 1011. Capacity To Ship Packages Within D Days
			P65. 875. Koko Eating Bananas

Day 20	--Hashing
			--Technique by which Search, Insert and delete operations can be done in O(1) average time
			--Hash vs Arrays - Time complexities for different operations
			--Do not store data in sorted form

		--Use cases
			--Password protection, Dictionaries, Databases - Indexing, Fetching data 

		--HashSet & HashMap<K, V>

		--Hashing Level 1
			P66. Print Unique element in an array / count of elements in array
			P67. 1. Two Sum - O(n)
			P68. 349. Intersection of Two Arrays
			P69. 560. Subarray Sum Equals K 
			
			
Day 21	--Hashing Level 2	
			P71. 13. Roman to Integer
			P72. 525. Contiguous Array
			
			P74. Count distinct elements in every window
				 https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1

Day 22	--Matrix / 2D Array
			P75. 867. Transpose Matrix
			P76. 36. Valid Sudoku
			P77. 48. Rotate Image
			

Day 23	--String & StringBuilder
			P79. 242. Valid Anagram
			P80. 67. Add Binary
			P81. 14. Longest Common Prefix

Day 24	--LinkedList
			--Schemetic view, Node Structure of Single, Doubly LinkedList	

		--Use Cases
			--Implementation of other data structure like Stacks, Queues, Hashmaps, HashSets & Graphs.
			--Dynamic memory allocation
			--Image Gallary, Music Player, Previous & next Page in Web Browsers.

		--Implementation of LinkedList & its behaviours.
			--Traversal / Printing
			--Recursive traversal
			--Size of LinkedList
			--Search
			--Insert first
			--Insert last
			--Delete first
			--Delete last
			--Insert at position
			--Delete at position

Day 25	--LinkedList Level 1
			P82. 707. Design Linked List
			P83. 876. Middle of the Linked List / Slow & Fast Pointer
			P84. 21. Merge Two Sorted Lists
			P85. 141. Linked List Cycle
			
Day 26	--LinkedList Level 2
			
			P87. 206. Reverse Linked List
			P88. 705. Design HashSet
			P89. 706. Design HashMap
	
Day 27	--LinkedList Level 3
			P90. 83. Remove Duplicates from Sorted List
			
			P92. 25. Reverse Nodes in k-Group

			P94. 2. Add Two Numbers

Day 28	--Queue 
			--Schematic view & FIFO mechanism
			--Use Cases
				--CPU Scheduling Algo like FCFS, Keyboard, Printers, Servers
	
		--Implementation
			--Enqueue / Add / Offer, Dequeue / Remove / Poll
			--LinkedList Implementation
			--Array Implementation
				Remove feature takes O(N) time
			--Circular Array Implementation

		--Collections / Queue Interface
			--offer(), poll(), peek(), size(), isEmpty()
			--Queue<Type> q = new LinkedList<>() OR Queue<Integer> q = new ArrayDeque<>()

		--Deque Interface / Doubly Ended Queue
			--insert / delete from front and rear
			--Deque acts as a Stack as well as Queue
				--offerFirst(), offerLast(), peekFirst(), peekLast(), pollFirst(), pollLast()

Day 29	--Stack
			--Schematic view & LIFO Mechanism
		--Use Cases
			--Function call Stack, Android back button, Undo button

		--Implementation of Stack
			--push(), pop(), peek(), underflow, overflow
			--Array Implementation
			--LinkedList Implementation
		
		--Stack Class in Collections
		--Reverse feature of Stack
			--The elements will develop in reverse order if you push them all into a stack and then pop them one at a time.
	
Day 30	--Stack / Queue Level 1
			P95. 20. Valid Parentheses
			P96. 232. Implement Queue using Stacks
			P97. 225. Implement Stack using Queues
			P98. Next Larger Element
				https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1/
		
Day 31	--Stack Level 2
			P99. 844. Backspace String Compare
			P100. 901. Online Stock Span
			
		
Day 32	--Stack Level 3
			P102. 84. Largest Rectangle in Histogram
			P103. 85. Maximal Rectangle

Day 33	--Recursion Level 2
			--Tail Recursion
				--when the recursive call is at the end of the method - similar to a loop
			--Head Recusrion
				--when the recursive call is in beginning of the method
				--method saves the state of method before jumping on to next recursive call

			P104. Tower of Hanoi
			P105. 1823. Find the Winner of the Circular Game / Josephus Problem 
			P106. Power Set
				  https://practice.geeksforgeeks.org/problems/power-set4302/1 
			P107. 78. Subsets
		
Day 32	--Recursion Level 3
			P108. 46. Permutations
			
			P110. 90. Subsets II
				
Day 33	--Recursion Level 4
			P111. 17. Letter Combinations of a Phone Number
			P112. 39. Combination Sum
			
			P114. 37. Sudoku Solver
			
Day 34	--Recursion Level 5
			P115. 51. N-Queens
			

Day 35	--Tree / Non linear Data Structure & hexarchial dataStructure
		--Terminologies
			Node, Root, Parent, Child, Siblings, Leaf, Descendent, Ancestor, Degree
		--Implementation of Binary Tree
			--Node Structure
			--Can have max 2 children
			--Building a tree using inputs
	
		--Tree traversals - DFS - Depth first Search
			--Inorder LDR
			--Preorder DLR
			--Postorder LRD

		--Building tree from Preordered Array 
		--Find height of the tree
		--Find size of tree
		--Max/Min val in tree	
	
Day 36	--Binary Tree Level 1
			P119. 94. Binary Tree Inorder Traversal✅
			P120. 144. Binary Tree Preorder Traversal✅
			P121. 145. Binary Tree Postorder Traversal✅
			P122. 104. Maximum Depth of Binary TreeTree✅
			
			P123. 100. Same TreeTree✅
			
			P125. 102. Binary Tree Level Order Traversal✅
			P126. 116. Populating Next Right Pointers in Each Node✅
			P127. 112. Path Sum✅
			
Day 37	--Binary Tree Level 2
			P128. 226. Invert Binary Tree✅
			P129. 543. Diameter of Binary TreeTree✅	
			P130. Left View
				  https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
		
			P132. Top View :- hori
				  https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

Day 38	--Binary Tree Level 3
			P133. 437. Path Sum III✅
			P134. 236. Lowest Common Ancestor of a Binary TreeTree✅
			P135. 105. Construct Binary Tree from Preorder and Inorder Traversal
		
Day 39	--Binary Search Tree
			--Nodes on left will always be smaller than root
			--Nodes on right will always be greater than root
		--Construction
			--Insertion O(log N)
			--LDR will always be sorted
		
		--Binary Search Tree Level 1
			P136. 98. Validate Binary Search Tree
		
			P138. 230. Kth Smallest Element in a BST
			P139. 450. Delete Node in a BST

Day 40	--Binary Search Tree Level 2	
			P140. 235. Lowest Common Ancestor of a Binary Search Tree
			P141. 108. Convert Sorted Array to Binary Search Tree
			

Day 41	--Binary Heap
			--Heap is a complete binary tree following the heap properties
			--Complete binary tree
				--Every level is filled except last level
				--Nodes will always be added from the left side
		--Types
			--Max heap - root will always be greater then childrens
			--Min heap -root will always be smaller then childrens

		--If a tree is in array form (level order, taking tree root at index 1)
			root = i, left = 2*i, right = 2*i + 1

		--Operations on Binary Heap 
			--Insert / delete - O(log N) 
			--Generate heap from array
			--Insertion
			--deletion
			--HeapSort - O(N log N)	
			--Heapify

		--PriorityQueue
			--offer(), poll(), peek()
			--Min heap is created by default
			--new PriorityQueue<>(Collections.reverseOrder()) - max heap

Day 42	--Comparator<T> Interface
			--Override compare(T o1, T o2) method either Make a seperate class or pass as an args / lambda
			--We can have any number of Comparators for a Type T
		
		--Comparable<T> Interface
			--Applies on the type itself
			--Override compareTo(T o) method

		--Priority Queue Level 1
			P143. 1046. Last Stone Weight
			P144. 215. Kth Largest Element in an Array

Day 43	--Priority Queue Level 2
			
			P146. 347. Top K Frequent Elements
			
			P148. 23. Merge k Sorted Lists

Day 44	--Graph Theory
			--Schematic view & Terms
				Node / Vertex - V, Edges - E, Path = can not have repeated Vertex, Components
		--Types
			--Directed 
				Indegree, outdegree, max edges = V * (V - 1)
			--Undirected
				Degree - Number of edges connected to it
				Sum of degree = 2 * E, Max edges = V*(V-1)/2	
			--Weighted graph
				If there is no weight, then assume weight 1 for every Edge
			--Cyclic graph
				Directed, Undirected
			--Acyclic graph
				Directed(DAG), Undirected

		--Representation & Implementation
			--Adjacency Matrix
				--Create a matrix of V * V
				--Mark 1 if there is an edge between the Vi & Vj else 0
				--In case of weighted graph positive value represents an edge as well as its weight else 0
				--Space Complexity O (V^2)
				--Space wastage

			--Adjacency List
				--Create a List/Map of linked list
				--Space complexity
					--Directed - O(V + E)
					--Undirected - O(V + 2E)

Day 45	--Graph Algorithms 
			P149. Breadth First Search (BFS)
				  https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
			P150. Depth First Search (DFS)
				  https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

Day 46	--Graph Algorithms 
			P151. Cycle detection in Undirected graph (DFS & BFS Based)
				  https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
			P152. Cycle detection in Directed graph (DFS based)
				  https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
			P153. Topological sort Using DFS
				  https://practice.geeksforgeeks.org/problems/topological-sort/1	
				  --Only valid in DAG, If there is no valid T-sort of a graph then there exists cycle in Graph

Day 47	--Graph Algorithms 
			P154. Topological sort Using BFS (Kahn's Algorithm)
				  https://practice.geeksforgeeks.org/problems/topological-sort/1	
		   		  
				--Kahn's Algorithm
					1 - Find Indegree of each vertex
					2 - Put all the vertex with 0 indegree in queue
					3 - Apply BFS on queue
					4 - Iterate through each neighbor of V and reduce their indegree by 1, if becomes 0 put in queue
					5 - repeat 3

				--Cycle Detection Using BFS Kahn's
					1 - Increment count while polling an element
					2 - return count != V 

			P155. 841. Keys and Rooms
			P156. 797. All Paths From Source to Target
			P157. 200. Number of Islands

Day 48	--Graph Algorithms - SPA
			--Shortest Path using Dijkstra's Algorithm in Undirected, Wighted graph (ONLY POSITIVE WEIGHTS)
				1 - dist[V] = inf
				2 - dist[s] = 0
				3 - Pick the shortest dist vertex and relax its neighbors
						if dist[n] >dist[v] + weight(v, n)
							dist[n] = dist[v] + weight(v, n)
				4 - Repeat the process

			--Bellman Ford Shortest path on Directed, Weighted, negative acyclic
				--Algorothm
					1 - dist[V] = INF
					2 - dist[s] = 0;
					3 - Relax the edges V-1 times
			P158. Shortest path in Directed Acyclic Graph
				  https://practice.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1
	
Day 49	--Graph Algorithms - Minimum Spanning Tree
			--Minimum Spanning tree 
				V vertex connected with exactly V-1 edges with minimum weights

			--Convert a Graph(Weighted, Connected, Undirected) to MST
				--Prim's Algo
					1 - Pick any V
					2 - find the min weight in cut and connect to that vertex
					3 - Repeat
			P159. Minimum Spanning Tree
				  https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1

		--Disjoint set
			--It is a data structure which stores multiple sets in a disjoint(non connective) manner that is two sets 
		   	   don't have any elements in common. Their intersection of sets is always null
		
			--Operations
				--add(Element e) - Add new sets to the DSU
				--find(Element e) - returns the parent of set in which e is present
				--union(Element e1, Element e2) - merge two sets on the basis of ranks / size

			--Path compression
				Technique by which the path / depth of the DSU tree can be reduced hence resulting in lower 
				time complexity of find() operation.
		
		--Kruskal's Algo for finding MST
			--Algorithm
				1 - Sort all edges by weight
				2 - res = 0, mst = {}
				3 - for every edge e till MST has exactly V-1 edges
					if adding e to MST does not cause a cycle 
					add e to MST
					res = res + weight of e

Day 50	--Graph Level 2
			P160. 733. Flood Fill
			P161. 133. Clone Graph
			P162. 547. Number of Provinces

			P166. 207. Course Schedule
			P167. 787. Cheapest Flights Within K Stops

Day 51	--Sliding Window
			--Window Size K
			--Identification
				--Subarray, Substring -> largest, min, max, unique, K
		--Sliding Window Level 1
			P168. Max Sum Subarray of size K 
				  https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1/
			P169. 3. Longest Substring Without Repeating Characters
			

Day 52	--Sliding Window Level 2
			P171. 76. Minimum Window Substring
			

Day 53	--Dynamic Programming
			--Optimize the recursive solution
			--Store the answer of overlapping subproblems
			--Instead of recalculating just use the previously saved answer
		--How can DP be achived
			--Memoisation - recursive
				--Using an array - 1D/2D
			--Tabulation - iterartive

		--Dynamic Programming Level 1 - Fibonacci
			P173. 509. Fibonacci Number
				  BF -TC - O(2^N)
				  Memo - TC - O(N)
			P174. 70. Climbing Stairs
			P175. 746. Min Cost Climbing Stairs
			P176. 55. Jump Game	
			

Day 54	--Dynamic Programming Level 2 - 0/1 Knapsack		
			P178. 0/1 Knapsack base code
			P180. 416. Partition Equal Subset Sum
			P181. 494. Target Sum

Day 55	--Dynamic Programming Level 3 - Unbounded Knapsack
			P182. 518. Coin Change II
			P183. 322. Coin Change
			

Day 56	--Dynamic Programming Level 4
			P185. 1143. Longest Common Subsequence
				  BF -TC - O(2^(m+n))
				  Memo - TC - O(m*n)
				  Tab - TC - O(m*n)
			P186. Longest Common Substring
				  https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1

			P188. 583. Delete Operation for Two Strings
			P189. 1092. Shortest Common Supersequence

Day 57	--Dynamic Programming Level 5 - Palindromic Subsequence
			P190. 516. Longest Palindromic Subsequence
			P191. 5. Longest Palindromic Substring
				      BF - O(N^3) N for pallindrome check * N^2 for all possible substrings
			P192. 647. Palindromic Substrings
			P193. 131. Palindrome Partitioning
			P194. 1312. Minimum Insertion Steps to Make a String Palindrome
			
Day 58	--Dynamic Programming Level 6
			P195. 72. Edit Distance	
			P196. 300. Longest Increasing Subsequence









				<!--! ali extra sheet  -->
<h1>ALI SHEET</h1>

P32. 1299. Replace Elements with Greatest Element on Right Side
P35. 905. Sort Array By Parity
P36. 1480. Running Sum of 1d Array
--Move all Negative elements to one side
			--https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
P42. 122. Best Time to Buy and Sell Stock II
P45. 4. Median of Two Sorted Arrays

Cyclic Sort

P51. 287. Find the Duplicate Number

BS

P56. 278. First Bad Version
P61. Search in an Infinte sorted array
P62. 74. Search a 2D Matrix

Hashing

P70. Longest Sub-Array with Sum K 
		 https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1/
P73. 128. Longest Consecutive Sequence

2D

P78. 54. Spiral Matrix

LL

P86. 142. Linked List Cycle II
P91. 160. Intersection of Two Linked Lists
P93. 19. Remove Nth Node From End of List

Stack

P101. 155. Min Stack

Rec

P109. 47. Permutations II
P113. 40. Combination Sum II
P116. 52. N-Queens II
P117. 79. Word Search
P118. 60. Permutation Sequence

BT

P124. 101. Symmetric Tree
P131. 199. Binary Tree Right Side View

BST

P137. 700. Search in a Binary Search Tree
P142. 99. Recover Binary Search Tree

PQ

P147. 295. Find Median from Data Stream
P145. 973. K Closest Points to Origin

Graph

P163. 695. Max Area of Island
P164. 994. Rotting Oranges

Sliding

P170. 438. Find All Anagrams in a String
P172. 239. Sliding Window Maximum

DP

P177. 198. House Robber
P179. Subset sum problem
				  https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
P184. Maximum cuts
				  https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
P187. Minimum number of deletions and insertions.
				  https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1
P194. 1312. Minimum Insertion Steps to Make a String Palindrome
P195. 72. Edit Distance
