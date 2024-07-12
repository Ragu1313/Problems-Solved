/*
1717. Maximum Score From Removing Substrings
Solved
Medium
Topics
Companies
Hint

You are given a string s and two integers x and y. You can perform two types of operations any number of times.

    Remove substring "ab" and gain x points.
        For example, when removing "ab" from "cabxbae" it becomes "cxbae".
    Remove substring "ba" and gain y points.
        For example, when removing "ba" from "cabxbae" it becomes "cabxe".

Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.

Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20

 

Constraints:

    1 <= s.length <= 105
    1 <= x, y <= 104
    s consists of lowercase English letters.


*/
class Solution {
    public int maxi(String s,int x,int y,String first){
        Stack<Character> ch = new Stack<>();
        int total=0;
        int p1=0;
        for(int i=0;i<s.length();i++){
            ch.push(s.charAt(i));
        }
        // System.out.println(ch);
        // System.out.println(first);
        while(p1<ch.size()-1){
            if(ch.get(p1)==first.charAt(0) && ch.get(p1+1)==first.charAt(1)){
                ch.remove(p1);
                ch.remove(p1);
                p1=Math.max(0,p1-2);
                total+=x;
            }
            else
                p1++;
        }
        p1=0;
        // System.out.println(total);
        // System.out.println(ch);
        while(p1<ch.size()-1){
            if(ch.get(p1)==first.charAt(1) && ch.get(p1+1)==first.charAt(0)){
                ch.remove(p1);
                ch.remove(p1);
                p1=Math.max(0,p1-2);
                total+=y;
            }
            else
                p1++;
        }
        return total;
    }
    public int maximumGain(String s, int x, int y) {
        if(x>y){
            return maxi(s,x,y,"ab");
        }
        else{
            return maxi(s,y,x,"ba");
        }
        
    }
}
