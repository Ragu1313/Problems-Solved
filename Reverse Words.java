/*
Reverse Words
Difficulty: EasyAccuracy: 56.08%Submissions: 332K+Points: 2
Given a String str, reverse the string without reversing its individual words. Words are separated by dots.

Note: The last character has not been '.'. 

Examples :

Input: str = i.like.this.program.very.much
Output: much.very.program.this.like.i
Explanation: After reversing the whole string(not individual words), the input string becomes much.very.program.this.like.i
Input: str = pqr.mno
Output: mno.pqr
Explanation: After reversing the whole string , the input string becomes mno.pqr
Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(|str|)

Constraints:
1 <= |str| <= 105
*/

class Solution {
    // Function to reverse words in a given string.
    String reverseWords(String str) {
        // code here
        String[] s = str.split("\\.");
        // System.out.println(s.length);
        if(s.length==0)
            return str;
        String res = s[s.length-1];
        for(int i=s.length-2;i>=0;i--){
            // System.out.println(s[i]);
            res=res+"."+s[i];
        }
        return res;
    }
}
