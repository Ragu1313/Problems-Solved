class Solution {
    public int maxWater(int arr[]) {
        int n = arr.length;
        int prevgre[] = new int[n];
        Arrays.fill(prevgre,-1);
        int nextgre[] = new int[n];
        Arrays.fill(nextgre,-1);
        
        Stack<Integer> st = new Stack<>();
        nextgre[n-1] = n-1;
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i] ){
                st.pop();
            }
            if(!st.isEmpty()){
                nextgre[i] = st.peek();
            }
            else{
                nextgre[i] = i;
                st.push(i);
            }
            
        }
        st = new Stack<>();
        prevgre[0] = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                prevgre[i] = st.peek();
            }
            else{
                prevgre[i] = i;
                st.push(i);
            }
            
            
        }
        int res = 0;
        for(int i=0;i<n;i++){
            // System.out.println(prevgre[i]+" "+nextgre[i]);
            if(prevgre[i]!=i && nextgre[i]!=i){
                int temp = Math.min(arr[nextgre[i]],arr[prevgre[i]])- arr[i];
                // System.out.println(temp);
                res += temp;
            }
        }
        return res;
    }
}
