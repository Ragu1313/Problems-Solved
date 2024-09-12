/*
Nth Natural Number
Difficulty: MediumAccuracy: 29.99%Submissions: 80K+Points: 4
Given a positive integer n. You have to find nth natural number after removing all the numbers containing the digit 9.

Examples :

Input: n = 8
Output: 8
Explanation: After removing natural numbers which contains digit 9, first 8 numbers are 1,2,3,4,5,6,7,8 and 8th number is 8.
Input: n = 9
Output: 10
Explanation: After removing natural numbers which contains digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10 and 9th number is 10.
Expected Time Complexity: O(logn)
Expected Auxiliary Space: O(1)


Constraints:
1 ≤ n ≤ 109
*/
class Solution {
    long findNth(long n) {
        long res = 0;
        int c = 1;
        if(n==0)    return n;
        while(n>0){
           res+=(n%9*c);
           n = n/9;
           c = c*10;
        }
        return res;
    }
}
