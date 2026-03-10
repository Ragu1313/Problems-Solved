class Solution {
    public int countSubarrays(int[] arr) {
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        // st.push(arr.length);
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[i]<=arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                sum += (arr.length-i);
            }
            else{
                sum += (st.peek()-i);
            }
            st.push(i);
        }
        return sum;
    }
}
