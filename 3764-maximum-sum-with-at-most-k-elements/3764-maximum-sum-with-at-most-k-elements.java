class Pair{
    int row;
    int num;
    public Pair(int num,int row){
        this.num = num;
        this.row = row;
    }
}
class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Pair> p = new PriorityQueue<>((a,b)->Integer.compare(b.num,a.num));
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                p.add(new Pair(grid[i][j],i));
            }
        }
        long res = 0;
        while(k>0 ){
            Pair temp = p.poll();
            if(limits[temp.row]>0){
                // System.out.println(temp.num);
                res += temp.num;
                limits[temp.row]--;
                k--;
            }

            
        }
        return res;
    }
}