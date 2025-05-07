class Solution {
    
    public int minTimeToReach(int[][] move) {

        int n = move.length;    
        int m = move[0].length;
        int arr[][] = new int[n][m];
        for(int i [] : arr){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        int v1[] = {-1,0,1,0};
        int v2[] = {0,-1,0,1};
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int temp [] = q.poll();
            int val = temp[0];
            if(temp[1]==n-1 && temp[2]==m-1)    return val;
            for(int k=0;k<4;k++){
                int newi = temp[1] + v1[k];
                int newj = temp[2] + v2[k];
                if(newi>=0 && newj<m && newj>=0 && newi<n && arr[newi][newj]==Integer.MAX_VALUE){
                    if(move[newi][newj]>=val+1){
                        arr[newi][newj] = move[newi][newj]+1;
                    }
                    else{
                        arr[newi][newj] = val+1;
                    }
                    q.add(new int[]{arr[newi][newj],newi,newj});
                }
            }
        }

        return -1;

    }
}