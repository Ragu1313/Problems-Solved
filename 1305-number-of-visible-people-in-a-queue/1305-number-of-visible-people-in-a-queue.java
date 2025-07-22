class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[heights.length];
        for(int i=heights.length - 1 ;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]<heights[i] ){
                res[i]++;
                st.pop();
            }
            if(!st.isEmpty()){
                res[i]++;
            }
            st.push(i);
        }
        return res;
    }
}