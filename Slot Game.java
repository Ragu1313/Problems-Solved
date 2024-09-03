/*
Slot Game
Easy
40/40
Average time to solve is 10m
Contributed by
Asked in companies
Problem statement
You’re given a slot machine with four slots where each slot will contain the color Red(R), Yellow(Y), Green(G), Blue(B), respectively. You don’t know the colors of this slot beforehand. You have to guess the colors. When you guess the correct color for the correct slot, you get a perfect hit, and you get 2 points, but if you guess a color that exists in the machine but is in the wrong slot, you get a pseudo hit, and you get 1 point.

You’re given the original string representing the slots’ colors and the guess string, and your task is to calculate and return the total number of points you have scored.

Note:

A slot that has been counted as a perfect hit can never count as a pseudo-hit.
Example:

Original String = “RGYB” and Guess String = “YGRR”.

The second slot of both the guess and original matches, hence it’s a perfect hit. The guess string contains yellow, which is also present in the original string but not at the same slot as the guess slot. Hence it’s a pseudo hit. The guess string also contains two red slots, but the original string contains only one red which is also not at the same slot as the guess string; hence it is also a pseudo hit. Therefore total points will be 2+1+1= 4.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 5
length(original) = length(guess) = 4

Time limit: 1 sec
Sample Input 1
1
RGBY
GGRR
Sample Output 1:
3
Explanation of Sample Input 1:

The second slot of both the string matches. Therefore, it is a perfect hit, and we get 2 points. Our guess string contains the color Red ‘R’ two times, which is also present in the original string but only one time, and it is not in the same slot as the guess slot; hence we get a pseudo hit we get 1 point. Therefore total points will be 2+1=3.
Sample Input 2:
1
RGYB
YGRR
Sample Output 2:
4
Explanation of Sample Input 2:

The second slot of both the string matches. Therefore it is a perfect hit, and we get 2 points. Our guess strings also contain the color Yellow ‘Y’, which is also present in the original slot, but it is not in the same slot as the guess string; hence we get a pseudo hit, and we get 1 point. Similarly, Our guess strings also contain the color  Red ‘R’ two times, which is also present in the original slot but only once, and it is not in the same slot as the guess string; hence we get a pseudo hit and get 1 point. Hence total points will be 2+1+1=4.
*/

import java.util.* ;
import java.io.*; 
public class Solution {
	public static int slotScore(String s1, String s2) {
		int []visited = new int[s2.length()];
		int res = 0;
		for(int i=0;i<s1.length();i++){
			char temp = s1.charAt(i);
			if(temp==s2.charAt(i)){
				if(visited[i]==1)
					res-=1;
				res+=2;
				visited[i] = 1;
			}
			else{
				for(int j=0;j<s2.length();j++){
					if(visited[j]!=1 && temp==s2.charAt(j)){
						res+=1;
						visited[j] = 1;
						break;
					}
				}
			}

		}
		return res;
	}
}
