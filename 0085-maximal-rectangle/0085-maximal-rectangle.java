class Solution {

    public int f(int arr[],int n){
        int pre[] = new int[n];
        int suf[] = new int[n];
        Arrays.fill(pre,-1);
        Arrays.fill(suf,n);
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])  pre[st.pop()] = i;
            // if(!st.isEmpty())   suf[i] = st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i])  suf[st.pop()] = i;
            // if(!st.isEmpty())  pre[i] = st.peek();
            st.push(i);
        }
        int res = 0;
        for(int i=0;i<n;i++){
            res = Math.max(res,arr[i]*(suf[i]-pre[i]-1));
        }
        return res;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int arr[][] = new int[n][m];
        for(int i=0;i<m;i++){
            if(matrix[0][i]!='0')   arr[0][i] = 1;
        }
        int res = f(arr[0],m);
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]!='0') arr[i][j] = 1+arr[i-1][j];
            }
            res = Math.max(res,f(arr[i],m));
        }
        return res;
    }
}