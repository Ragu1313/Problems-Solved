/*


Missing And Repeating
Difficulty: MediumAccuracy: 24.83%Submissions: 507K+Points: 4
Given an unsorted array arr of of positive integers. One number 'A' from set {1, 2,....,n} is missing and one number 'B' occurs twice in array. Find numbers A and B.

Examples

Input: arr[] = [2, 2]
Output: 2 1
Explanation: Repeating number is 2 and smallest positive missing number is 1.
Input: arr[] = [1, 3, 3] 
Output: 3 2
Explanation: Repeating number is 3 and smallest positive missing number is 2.
Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)

Constraints:
2 ≤ n ≤ 105
1 ≤ arr[i] ≤ n
*/


class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        int maxi = 0;
        for(int i=0;i<arr.length;i++)
            maxi = Math.max(maxi,arr[i]);
        int cnt[] = new int[maxi+2];
        // int prev = arr[0];
        cnt[arr[0]]++;
        for(int i=1;i<arr.length;i++){
            cnt[arr[i]]++;
        }
        int cur = -1;
        for(int i=0;i<maxi+1;i++){
            if(cnt[i]==2){
                cur = i;
            }
        }
        for(int i=cur-1;i>0;i--){
            if(cnt[i]==0){
                return new int[]{cur,i};
            }
        }
        for(int i=cur+1;i<=maxi+1;i++){
            if(cnt[i]==0)
                return new int[]{cur,i};
        }
        return new int[]{0,0};  
    }
}
