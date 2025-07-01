// "3+2*2" → should be 7  
// Your logic:  
// "3+2*2" → calculate `/` → nothing  
// → calculate `*` → `2*2 = 4` → becomes `3+4`  
// → calculate `+` → 7 ✅

// But `"14-3/2"` →  should be `14 - (3/2) = 13`  
// Your logic:  
// `"14-3/2"` → handle `/` → 3/2 = 1 → `"14-1"`  
// → `13` ✅

// But if the input had `"3+5 / 2"` → becomes `"3+2"` → okay.

// Still, the **sign handling and stack logic is fragile**.

// ---

// ### ✅ Fully Working & Cleaned-Up Version

// Here’s a fixed and clean version of your logic:

// ```java
// import java.util.*;

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+'; // initial operator
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = ch;
                num = 0;
            }
        }

        int result = 0;
        for (int val : stack) result += val;
        return result;
    }
}
