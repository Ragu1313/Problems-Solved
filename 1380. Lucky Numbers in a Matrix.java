/*

Code
Testcase
Test Result
Test Result
1380. Lucky Numbers in a Matrix
Solved
Easy
Topics
Companies
Hint
Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

 

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 105.
All elements in the matrix are distinct.
*/
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int i;
        int j;
        int res;
        int index=0;
        // int arr[] = new int[1];
        ArrayList<Integer> a = new ArrayList<>();
        int l = matrix[0].length;
        int flag =0;
        for(i=0;i<l;i++){
            flag =0;
            res=Integer.MIN_VALUE;
            for(j=0;j<matrix.length;j++){
                if(res<matrix[j][i]){
                    res=matrix[j][i];
                    index = j;
                }
            }
            for(j=0;j<l;j++){
                if(matrix[index][j]<res){
                    flag = 1;
                    break;
                }
            }
            if(flag==0){
                a.add(res);
                break;
            }
        }
        return a;
    }
}
