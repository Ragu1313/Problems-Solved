/*
 Count Subsets with Sum K
Moderate
80/80
Contributed by
407 upvotes
Asked in company
Problem statement
You are given an array 'arr' of size 'n' containing positive integers and a target sum 'k'.



Find the number of ways of selecting the elements from the array such that the sum of chosen elements is equal to the target 'k'.



Since the number of ways can be very large, print it modulo 10 ^ 9 + 7.



Example:
Input: 'arr' = [1, 1, 4, 5]

Output: 3

Explanation: The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
4 5
1 4 4 5


Sample Output 1 :
 3


Explanation For Sample Output 1:
The possible ways are:
[1, 4]
[1, 4]
[5]
Hence the output will be 3. Please note that both 1 present in 'arr' are treated differently.


Sample Input 2 :
3 2
1 1 1


Sample Output 2 :
3


Explanation For Sample Output 1:
There are three 1 present in the array. Answer is the number of ways to choose any two of them.


Sample Input 3 :
3 40
2 34 5


Sample Output 3 :
0


Expected time complexity :
The expected time complexity is O('n' * 'k').


Constraints:
1 <= 'n' <= 100
0 <= 'arr[i]' <= 1000
1 <= 'k' <= 1000

Time limit: 1 sec
*/

import java.util.*;
import java.io.*;

public class Solution {
    static int mod = 1000000007;
    public static int find(int i,int nums[],int tar,int dp[][]){
        if(i==0){
            if(nums[0]==0 && tar==0)
                return 2;
            if(tar==0 || nums[0]==tar)
                return 1;
            else    
                return 0;
        }
        if(dp[i][tar]!=-1)
            return dp[i][tar];
        int take = 0;
        if(nums[i]<=tar)
            take = find(i-1,nums,tar-nums[i],dp);
        int nottake = find(i-1,nums,tar,dp);
        return dp[i][tar] = (take + nottake)%mod;

    }
    public static int findWays(int nums[], int tar) {
        int dp[][] = new int [nums.length][tar+1];
        for(int i[] : dp)
            Arrays.fill(i,-1);
        return find(nums.length-1,nums,tar,dp);
    }
}
