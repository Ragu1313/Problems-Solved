/*
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms.

Examples:

Input: n = 6, arr[] = {0900, 0940, 0950, 1100, 1500, 1800}, 
            dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation: There are three trains during the time 0940 to 1200. So we need minimum 3 platforms.
Input: n = 3, arr[] = {0900, 1235, 1100}, 
            dep[] = {1000, 1240, 1200}
Output: 1
Explanation: All train times are mutually exlusive. So we need only one platform
Input: n = 3, arr[] = {1000, 0935, 1100}, 
            dep[] = {1200, 1240, 1130}
Output: 3
Explanation: All 3 trains have to be their from 11:00 to 11:30
 

Note: Time intervals are in the 24-hour format(HHMM) , where the first two characters represent hour (between 00 to 23 ) and the last two characters represent minutes (this will be <= 59 and >= 0).

Expected Time Complexity: O(nLogn)
Expected Auxiliary Space: O(n)

Constraints:
1 ≤ n ≤ 50000
0000 ≤ arr[i] ≤ dep[i] ≤ 2359
*/

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
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
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        quicksort(0,arr.length-1,arr,dep);
        
        int a[] = new int [dep.length];
        Arrays.fill(a,-1);
        int pointer = 0,pointer2 =1;
        a[0] = dep[0];
        int prev = a[0];
        int res = 1;
        
        for(int i=1;i<dep.length;i++){
            // System.out.println(dep[i]);
            if(prev<=arr[i]){
                a[pointer] = dep[i];
                prev = dep[i];
                continue;
            }
            else if(prev>arr[i]){
                if(a[pointer] < arr[i] ){
                    a[pointer2++] = dep[i];
                    pointer++;
                }
                else{
                    a[pointer2++] = dep[i];
                    res++;
                }
            }
            prev = dep[i];
        }
        return res;
    }
    
}
