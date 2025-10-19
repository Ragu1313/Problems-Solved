import java.util.*;

class Solution {
    String res;
    Set<String> visited = new HashSet<>();

    public void find(String s, int a, int b) {
        
        if (!visited.add(s)) return;

        
        if (s.compareTo(res) < 0) res = s;

        
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
        }
        String added = new String(chars);
        find(added, a, b);

       
        String rotated = s.substring(s.length() - b) + s.substring(0, s.length() - b);
        find(rotated, a, b);
    }

    public String findLexSmallestString(String s, int a, int b) {
        res = s;
        find(s, a, b);
        return res;
    }

    
}
