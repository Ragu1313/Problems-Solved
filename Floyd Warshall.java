/*
Floyd Warshall
Difficulty: MediumAccuracy: 32.89%Submissions: 141K+Points: 4
The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. If Matrix[i][j]=-1, it means there is no edge from i to j.
Note : Modify the distances for every pair in-place.

Examples :

Input: matrix = [[0, 25],[-1, 0]]

Output: [[0, 25],[-1, 0]]

Explanation: The shortest distance between every pair is already given(if it exists).
Input: matrix = [[0, 1, 43],[1, 0, 6],[-1, -1, 0]]

Output: [[0, 1, 7],[1, 0, 6],[-1, -1, 0]]

Explanation: We can reach 2 from 0 as 0->1->2 and the cost will be 1+6=7 which is less than 43.
Expected Time Complexity: O(n3)
Expected Space Complexity: O(1)

Constraints:
1 <= n <= 100
-1 <= matrix[ i ][ j ] <= 1000
*/

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        
        int v = matrix.length;
        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                if(matrix[i][j]==-1)
                matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        int m = Integer.MAX_VALUE;
        for(int k = 0;k<v;k++){
            for(int i=0;i<v;i++){
                for(int j = 0;j<v;j++){
                    if(matrix[k][j]!=m && matrix[i][k]!=m)
                    matrix[i][j] = Math.min(matrix[i][j],(matrix[i][k] + matrix[k][j]));
                }
            }
        }
         for(int i=0;i<v;i++)
        {
            for(int j=0;j<v;j++)
            {
                if(matrix[i][j]==Integer.MAX_VALUE)
                  matrix[i][j]= -1;
                
            }
        }
    }
}
