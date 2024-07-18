/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).

 

Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
Example 2:

Input: matrix = [[-5]], k = 1
Output: -5
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
 

Follow up:

Could you solve the problem with a constant memory (i.e., O(1) memory complexity)?
Could you solve the problem in O(n) time complexity? The solution may be too advanced for an interview but you may find reading this paper fun.

*/
class Solution {
    public void heapify(int arr[],int i,int n){
        int largest = i;
        int left = i*2+1;
        int right = i*2+2;
        if(left<n && arr[left]<arr[largest])
            largest = left;
        if(right<n && arr[right]<arr[largest])
            largest = right;
        if(largest != i){
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            heapify(arr,largest,n);
        }
    }
    public int heapsort(int arr[],int k){
        int n = arr.length;
        for(int i=n/2-1;i>=0;i--)
            heapify(arr,i,n);
        for(int i=n-1;i>=0;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            if(--k==0)
                return arr[i];
            heapify(arr,0,i);
        }
        return -1;
    }
    public int kthSmallest(int[][] matrix, int k) {
        // ArrayList<Integer> a = new ArrayList<>();
        int arr[] = new int[matrix.length * matrix[0].length];
        int position =0;
        for(int[] i : matrix){
            for(int j:i){
                arr[position++] = j;
            }
        }
        return heapsort(arr,k);
    }
}


