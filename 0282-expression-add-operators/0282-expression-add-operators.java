class Solution {
    List<String> res;

    public void helper(int ind, String num, int n, long cur, long prev, int target, StringBuilder sb) {
        if (ind == n) {
            if (cur == target) {
                res.add(sb.toString());
            }
            return;
        }

        for (int i = ind; i < n; i++) {
            // Skip numbers with leading zeros
            if (i > ind && num.charAt(ind) == '0') break;

            String part = num.substring(ind, i + 1);
            long val = Long.parseLong(part);
            int len = sb.length();

            if (ind == 0) {
                // First number, no operator before it
                sb.append(part);
                helper(i + 1, num, n, val, val, target, sb);
                sb.setLength(len);
            } else {
                // '+'
                sb.append('+').append(part);
                helper(i + 1, num, n, cur + val, val, target, sb);
                sb.setLength(len);

                // '-'
                sb.append('-').append(part);
                helper(i + 1, num, n, cur - val, -val, target, sb);
                sb.setLength(len);

                // '*'
                sb.append('*').append(part);
                helper(i + 1, num, n, cur - prev + prev * val, prev * val, target, sb);
                sb.setLength(len);
            }
        }
    }

    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(0, num, num.length(), 0, 0, target, new StringBuilder());
        return res;
    }
}
