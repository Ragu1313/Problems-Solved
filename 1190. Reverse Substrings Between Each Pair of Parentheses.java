/*
1190. Reverse Substrings Between Each Pair of Parentheses
Solved
Medium
Topics
Companies
Hint
You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

 

Example 1:

Input: s = "(abcd)"
Output: "dcba"
Example 2:

Input: s = "(u(love)i)"
Output: "iloveu"
Explanation: The substring "love" is reversed first, then the whole string is reversed.
Example 3:

Input: s = "(ed(et(oc))el)"
Output: "leetcode"
Explanation: First, we reverse the substring "oc", then "etco", and finally, the whole string.
 

Constraints:

1 <= s.length <= 2000
s only contains lower case English characters and parentheses.
It is guaranteed that all parentheses are balanced.
*/
class Solution {
    public String reverseParentheses(String s1) {
        int i;
        String s = "";
        String result="";
        Stack<String> stack = new Stack<>();
        for(i=0;i<s1.length();i++){
            String a = String.valueOf(s1.charAt(i));
            if(!a.equals(")")) 
                stack.push(a);
            else{
                s = "";
                while(!stack.isEmpty()){
                    String ch = stack.pop();
                    if(ch.equals("("))
                        break;
                    s+=ch;
                }
                for(int j=0;j<s.length();j++){
                    stack.push(String.valueOf(s.charAt(j)));
                }    
                
            }    
        }
         while (!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;
    }
}
