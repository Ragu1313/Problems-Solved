/*
Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n
*/
class Solution {
    public void per(int i,int [] arr,int k,List<List<Integer>> res,List<Integer> p){
        if(p.size()==k){
            res.add(new ArrayList<>(p));
            return ;
        }
        for(int j=i;j<arr.length;j++){
           p.add(arr[j]);
           per(j+1,arr,k,res,p);
           p.remove(p.size()-1); 
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        if(n==1 && k==1){
            p.add(1);
            res.add(p);
            return res;
        }
        int arr[] = new int [n];
        for(int i=0;i<n;i++){
            arr[i] = i+1;
        }
        per(0,arr,k,res,p);
        return res;
    }
}
