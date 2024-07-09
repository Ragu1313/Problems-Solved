/*
Activity Selection
Difficulty: MediumAccuracy: 36.21%Submissions: 129K+Points: 4
Given N activities with their start and finish day given in array start[ ] and end[ ]. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a given day.
Note : Duration of the activity includes both starting and ending day.


Example 1:

Input:
N = 2
start[] = {2, 1}
end[] = {2, 2}
Output: 
1
Explanation:
A person can perform only one of the
given activities.
Example 2:

Input:
N = 4
start[] = {1, 3, 2, 5}
end[] = {2, 4, 3, 6}
Output: 
3
Explanation:
A person can perform activities 1, 2
and 4.

Your Task :
You don't need to read input or print anything. Your task is to complete the function activityselection() which takes array start[ ], array end[ ] and integer N as input parameters and returns the maximum number of activities that can be done.


Expected Time Complexity : O(N * Log(N))
Expected Auxilliary Space : O(N)

Constraints:
1 ≤ N ≤ 2*105
1 ≤ start[i] ≤ end[i] ≤ 109
*/

class Solution
{
    public static void quicksort(int low,int high,int start[],int end[]){
        if(low>=high)
			 return ;
        int i = low;
        int j = high;
        int mid = i+(j-i)/2;
        int pivot = end[mid];
        while(i<=j){
            while(end[i]<pivot)
            i++;
            while(end[j]>pivot)
            j--;
            if(i<=j){
                int temp = end[i];
                end[i] = end[j];
                end[j] = temp;
                temp = start[i];
                start[i] = start[j];
                start[j] = temp;
                i++;
                j--;
            }
        }
        quicksort(low,j,start,end);
        quicksort(i,high,start,end);
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        quicksort(0,n-1,start,end);
        int res=1,prev = end[0];
        for(int i=1;i<start.length;i++){
            if(prev<start[i]){
                res++;
                prev = end[i];
            }
        }
        return res;
    }
}
