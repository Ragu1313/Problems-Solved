class Solution {
    public boolean bfs(int []arr,int start,int visited[],int n){
        Queue<Integer> q = new LinkedList<>();
        visited[start] = 1;
        // int n = arr.length;
        q.add(start);
        while(!q.isEmpty()){
            // int arr[] = q.poll();
            int index = q.poll();
            int val = arr[index];
            if(val==0)
                return true;
            int s = index-val;
            if(s>=0 && s<n && visited[s]==0){
                q.add(s);
                visited[s] = 1;
            }
            s = index+val;
            if(s>=0 && s<n && visited[s]==0){
                q.add(s);
                visited[s] = 1;
            }
        }
        return false;
    }
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int visited[] = new int[n];
        if(arr[start]==0)
            return true;
        return bfs(arr,start,visited,n);
    }
}