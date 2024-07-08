/*
 Problem statement

You have been given an array/list ‘A’ consisting of ‘N’ integers all of which are ‘0’ initially. You are given an array/list ‘ARR’ consisting of ‘M’ pairs of integers which are ‘M’ operations you need to perform on ‘A’. In each operation, you are given a range and you need to increase each element whose index lies in that range by ‘1’. Your task is to return the maximum element of array/list ‘A’ after all ‘M’ operations are performed.
Example:

Let’s assume ‘N’ is 5. Initially, all the elements are initialized to zero. we need to perform 2 operations 1 5 and 2 4. In operation 1 5, we will increase all the elements from index 1 to 5 by 1 i.e it becomes [1,1,1,1,1]. 

In operation 2 4, we will increase all the elements from index 2 to 4 by 1 i.e it becomes [1,2,2,2,1]. So answer in this case will be 2 as 2 is the maximum element of the array/list. 

Note:

In the above question array/list is assumed to have ‘1’ - based indexing i.e. array/list starts from index 1.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:

1 <= T <= 10
1 <= N <= 10^3
1 <= M <= 10^3
1 <= L <= N
L <= R <= N   

Time Limit: 1 sec

Sample Input 1:

2
2 2
1 2
1 1  
2 1
2 2

Sample Output 1:

2
1

Sample Output 1 Explanation:

Test case 1:

Initial array/list ‘A’ is [0,0]
Array/list ‘A’ after each operation:-
[1,1] → Elements with index in range of [1,2] gets incremented by 1.
[2,1] → Elements with index in range of [1,1] gets incremented by 1.  

Therefore the maximum element in array/list ‘A’ is 2.

Test case 2:

Initial array/list 'A' is [0,0]
Array/list ‘A’ after each operation:-
[0,1] → Elements with index in range of [2,2] gets incremented by 1.

Therefore the maximum element in array/list ‘A’ is 1.

Sample Input 2:

2
5 5
5 5
2 4
1 2
2 2
2 3
2 3
1 2
1 1
2 2

Sample Output 2:

4
2

Solution*/
import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int findMaxElement(ArrayList < ArrayList < Integer >> arr, int n, int m) {
        // Write your code here.
        int l = arr.size();
        int i;
        int a[] = new int[n];
        // for(i=1;i<=n;i++){
        //     a.add(0);
        // }
        i=0;
        int res=0;
        while(m-->0){
            ArrayList<Integer> b = arr.get(i);
            int i1 = b.get(0)-1;
            int i2 = b.get(1)-1;
            for(int j=i1;j<=i2;j++){
                if(j<n){
                    a[j]++;
                    if(res<a[j])
                        res=a[j];
                }
            }
            i++;
        }
        return res;
    }
}
