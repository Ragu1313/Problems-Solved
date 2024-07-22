/*
Maximum product subset of an array
Difficulty: MediumAccuracy: 17.21%Submissions: 74K+Points: 4

Given an array arr. The task is to find and return the maximum product possible with the subset of elements present in the array.

Note:

    The maximum product can be a single element also.
    Since the product can be large, return it modulo 109 + 7.

Examples:

Input: arr[] = [-1, 0, -2, 4, 3]
Output: 24
Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24

Input: arr[] = [-1, 0]
Output: 0
Explanation: Maximum product will be ( -1 * 0) = 0

Input: arr[] = [5]
Output: 5
Explanation: Maximum product will be 5.

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
1 <= arr.size() <= 2 * 104
-10 <= arr[i] <= 10

*/
class Solution {
    public long findMaxProduct(List<Integer> arr) {
        long res=1;
        int negative = 0;
        Collections.sort(arr);
        if(arr.size()==1){
            return arr.get(0);
        }
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<0){
                negative++;
            }
        }
        negative = negative%2==0?negative:negative-1;
        int flag=0;
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<0 && negative>0){
                 res=(res*arr.get(i))%1000000007;
                negative--;
                flag =1;
            }
            else if(arr.get(i)>0){
                 res=(res*arr.get(i))%1000000007;
                flag =1;
            }
        }
        if(flag==0){
            return 0;
        }
        return res%1000000007;
    }
}
