class Solution {
    public int largestRectangleArea(int[] hei) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = hei.length;

        // Initialize arrays for previous and next smaller indices
        int[] ns = new int[n];
        Arrays.fill(ns, n); // Default to n (no next smaller element)
        int[] ps = new int[n];
        Arrays.fill(ps, -1); // Default to -1 (no previous smaller element)

        // Compute previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!s1.isEmpty() && hei[s1.peek()] >= hei[i]) {
                s1.pop();
            }
            if (!s1.isEmpty()) {
                ps[i] = s1.peek();
            }
            s1.push(i);
        }

        // Compute next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!s2.isEmpty() && hei[s2.peek()] >= hei[i]) {
                s2.pop();
            }
            if (!s2.isEmpty()) {
                ns[i] = s2.peek();
            }
            s2.push(i);
        }

        // Calculate the largest rectangle area
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, hei[i] * (ns[i] - ps[i] - 1));
        }
        return res;
    }
}
