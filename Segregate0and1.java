/*
Segregate 0s and 1s
Difficulty: EasyAccuracy: 54.25%Submissions: 104K+Points: 2

Given an array arr consisting of only 0's and 1's in random order. Modify the array in-place to segregate 0s onto the left side and 1s onto the right side of the array.

Examples :

Input: arr[] = [0, 0, 1, 1, 0]
Output: [0, 0, 0, 1, 1]
Explanation:  After segregation, all the 0's are on the left and 1's are on the right. Modified array will be [0, 0, 0, 1, 1].

Input: arr[] = [1, 1, 1, 1]
Output: [1, 1, 1, 1]
Explanation: There are no 0s in the given array, so the modified array is [1, 1, 1, 1]

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 1
*/
class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int i=0;
        int l = arr.length-1;
        int j = l;
        while(i<=j){
            while(i<l && arr[i]==0)
                i++;
            while(j>=i && arr[j]==1)
                j--;
            if(i<=j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
    }
}