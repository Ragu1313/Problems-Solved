/*
100372. Number of Bit Changes to Make Two Integers Equal
Solved
Easy

You are given two positive integers n and k.

You can choose any bit in the binary representation of n that is equal to 1 and change it to 0.

Return the number of changes needed to make n equal to k. If it is impossible, return -1.

 

Example 1:

Input: n = 13, k = 4

Output: 2

Explanation:
Initially, the binary representations of n and k are n = (1101)2 and k = (0100)2.
We can change the first and fourth bits of n. The resulting integer is n = (0100)2 = k.

Example 2:

Input: n = 21, k = 21

Output: 0

Explanation:
n and k are already equal, so no changes are needed.

Example 3:

Input: n = 14, k = 13

Output: -1

Explanation:
It is not possible to make n equal to k.

*/
class Solution {
    public int minChanges(int n, int k) {
        if(n<k){
            return -1;
        }
        String s1 = Integer.toBinaryString(n);
        String s2 = Integer.toBinaryString(k);
        int l1 = s1.length();
        int l2 = s2.length();
        int c=0;
        s2 = "";
        while(l2!=l1){
            s2+="0";
            l2++;
        }
        s2+=Integer.toBinaryString(k);
        for(int i=0;i<l1;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                if(s1.charAt(i)=='0' && s2.charAt(i)=='1'){
                    return -1;
                }
                c++;
            }
        }
        return c;
        
    }
}
