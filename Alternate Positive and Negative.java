/*
 Alternate Positive and Negative
Easy
40/40
Average time to solve is 15m
Contributed by
Asked in companies
Problem statement
You are given an array ‘arr’ that contains an equal number of positive and negative elements. Rearrange the given array such that positive and negative numbers are arranged alternatively. Also, the respective relative order of positive and negative should be maintained.

For example:

For the given arr[ ] = { -1, 3, 5, 0, -2, -5 } 
arr[ ] = {3, -1, 5, -2, 0, -5 } is valid rearrangement.
arr[ ] = {3, -1, 0, -2, 5, -5 } is invalid rearrangement; order of 0 and 5 is changed. 
arr[ ] = {3, -1, 5, 0, -2, -5 } is invalid rearrangement; positive and negative elements are not alternative.
Note:

Make changes in the same array and no returning or printing is needed.
Consider zero(0) as a positive element for this question.
It is guaranteed that an answer always exists.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
1 <= N <= 5 * 10 ^ 3
-10 ^ 9 <= arr[i] <= 10 ^ 9

Time Limit: 1 sec.
Sample Input 1:
2
6
1 2 3 -1 -2 -3
8
1 -10 5 -1 2 -3 0 -2
Sample Output 1:
1 -1 2 -2 3 -3 
1 -10 5 -1 2 -3 0 -2 
Explanation of Sample Input 1:
In the first test case, the output is an array of alternative positive and negative numbers, and also order is maintained (relative order of positive numbers are 1 -> 2 -> 3 and for negative numbers are -1 -> 2 -> -3 )

In the first test case, it is already in valid arrangement.
Sample Input 2:
1
4
-1 0 0 -1
Sample Output 2:
0 -1 0 -1 
Explanation of Sample Output 2:
In the first test case, the output is an array of alternative positive and negative numbers and also order is maintained.
*/

import java.util.* ;
import java.io.*; 

public class Solution {
	public static void posAndNeg(int[] arr) {
		// Write your code here
		int [] pos = new int[arr.length/2];
		int [] neg = new int[arr.length/2];
		int p1=0,p2=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>=0)
				pos[p1++] = arr[i];
			else	
				neg[p2++] = arr[i];
		}
		 p1 = 0;
		for(int i=0;i<arr.length/2;i++){
			arr[p1++] = pos[i];
			arr[p1++] = neg[i];
		}
		
	}
}
