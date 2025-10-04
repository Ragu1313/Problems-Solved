class Solution {
    Set<String> res;

    public void f(int ind, long cur, long prev, StringBuilder sb, int target, String str, int n) {
        if (ind == n) {
            if (cur == target) res.add(sb.toString());
            return;
        }

        int len = sb.length();
        StringBuilder temp = new StringBuilder();

        for (int i = ind; i < n; i++) {
            temp.append(str.charAt(i));
            long dup = Long.parseLong(temp.toString());

            // handle leading zeros
            if (str.charAt(ind) == '0' && i > ind) break;

            if (ind == 0) {
                sb.append(temp);
                f(i + 1, dup, dup, sb, target, str, n);
                sb.setLength(len);
            } else {
                sb.append('+').append(temp);
                f(i + 1, cur + dup, dup, sb, target, str, n);
                sb.setLength(len);

                sb.append('-').append(temp);
                f(i + 1, cur - dup, -dup, sb, target, str, n);
                sb.setLength(len);

                sb.append('*').append(temp);
                f(i + 1, cur - prev + prev * dup, prev * dup, sb, target, str, n);
                sb.setLength(len);
            }
        }
    }

    public ArrayList<String> findExpr(String s, int target) {
        res = new HashSet<>();
        f(0, 0, 0, new StringBuilder(), target, s, s.length());
        return new ArrayList<>(res);
    }
}
