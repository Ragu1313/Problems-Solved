class Solution {
    Map<Integer,Integer> map = new HashMap<>();
    public void f(List<Integer> list,int grid[][]){
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        q.add(new int[]{grid[0][0],0,0});
        grid[0][0] = -1;
        int n1 = list.size();
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        int v1[] = {0,-1,0,1};
        int v2[] = {-1,0,1,0};
        for(int i=0;i<n1;i++){
            int ele = list.get(i);
            while(!q.isEmpty()){
                int temp[] = q.poll();
                if(ele<=temp[0]){
                    q.add(temp);
                    break;
                }
                cnt++;
                int row = temp[1];int col = temp[2];
                for(int j=0;j<4;j++){
                    int newrow = row + v1[j];
                    int newcol = col + v2[j];
                    if(newrow>=0 && newrow<n && newcol>=0 && newcol<m  && grid[newrow][newcol]!=-1){
                        q.add(new int[]{grid[newrow][newcol],newrow,newcol});
                        grid[newrow][newcol] = -1;
                    }
                }
            }
            map.put(ele,cnt);
        }
    }
    public int[] maxPoints(int[][] grid, int[] queries) {
        Set<Integer> set = new TreeSet<>();
        for(int i : queries){
            set.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i : set){
            list.add(i);
        }
        f(list,grid);
        int n = queries.length;
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i] = map.get(queries[i]);
        }
        return res;
    }

}