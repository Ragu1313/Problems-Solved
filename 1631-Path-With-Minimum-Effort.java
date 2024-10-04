class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public void bfs(int i1,int j1,int [][]mat,int [][]visited){
        Queue<int[]> q = new LinkedList<>();
        int n1 = mat.length;
        int m1 = mat[0].length;
        q.add(new int[]{i1,j1,0,mat[0][0]});
        int [] v1 = new int[]{-1,0,1,0};
        int [] v2 = new int[]{0,-1,0,1};
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int prev = arr[3];
            int i = arr[0];
            int j = arr[1];
            int diff = arr[2];
            if(i==n1-1 && j==m1-1){
                list.add(diff);
                continue;
            }
            for(int k=0;k<4;k++){
                int n = v1[k]+i;
                int m = v2[k]+j;
                if(n<n1 && n>=0 && m>=0 && m<m1){
                    int cur_dif = Math.abs(prev-mat[n][m]);
                    int maxi = Math.max(cur_dif,diff);
                    if(maxi<visited[n][m]){
                        q.add(new int[]{n,m,maxi,mat[n][m]});
                        visited[n][m] = maxi;
                    }
                    
                }
            }
        } 
    }
    public int minimumEffortPath(int[][] mat) {
        int visited[][] = new int[mat.length][mat[0].length];
        for(int i[]:visited){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        bfs(0,0,mat,visited);
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<list.size();i++){
            mini = Math.min(list.get(i),mini);
        } 
        return mini;
    }
}