/*
Given a string s of length n, find all the possible non-empty subsequences of the string s in lexicographically-sorted order.

Example 1:

Input : 
s = "abc"
Output: 
a ab abc ac b bc c
Explanation : 
There are a total 7 number of subsequences possible for the given string, and they are mentioned above in lexicographically sorted order.
Example 2:

Input: 
s = "aa"
Output: 
a a aa
Explanation : 
There are a total 3 number of subsequences possible for the given string, and they are mentioned above in lexicographically sorted order.
Your Task:
You don't need to read input or print anything. Your task is to complete the function AllPossibleStrings() which takes a string s as the input parameter and returns a list of all possible subsequences (non-empty) that can be formed from s in lexicographically sorted order.

Expected Time Complexity: O( n*2n  )
Expected Space Complexity: O( n * 2n )

Constraints: 
1 <= n <= 16
s constitutes of lower case english alphabets
*/
class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String> a = new ArrayList<>();
        int powerset = (int)Math.pow(2,s.length());
        for(int i=0;i<powerset;i++){
            String s1 = "";
            for(int j = 0;j<s.length();j++){
                if((i &(1<<j))>0){
                    s1= s1+s.charAt(j);
                    // .toStringValue();
                }
            }
            if(s1!=""){
                a.add(s1);
            }
        }
        Collections.sort(a);
        return a;
    }
}
