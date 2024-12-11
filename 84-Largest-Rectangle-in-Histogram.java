class Solution {
    public int largestRectangleArea(int[] hei) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int n = hei.length;

        int[] ns = new int[n];
        Arrays.fill(ns, n); 
        int[] ps = new int[n];
        Arrays.fill(ps, -1); 

        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && hei[s1.peek()] >hei[i]){
                int peek = s1.pop();
                ns[peek] = i;
                // s1.pop();
            }
            s1.push(i);
        }

        for(int i=n-1;i>=0;i--){
            while(!s2.isEmpty() && hei[s2.peek()]>hei[i]){
                int peek = s2.pop();
                ps[peek] = i;
            }
            s2.push(i);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res,hei[i]*(ns[i]-ps[i]-1));
        }
        return res;
    }
}
