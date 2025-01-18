class Solution {

    
    public int f(int grid[][]) {
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for (int i[] : vis) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        vis[0][0] = 0;
        p.add(new int[] { 0, 0, 0 });
        int v1[] = { 1, 0, -1, 0 };
        int v2[] = { 0, 1, 0, -1 };
        int v3[] = { 3, 1, 4, 2 };
        while (!p.isEmpty()) {

            int arr[] = p.poll();
            
            if (arr[1] == n - 1 && arr[2] == m - 1) {
                return arr[0];
            }
            for (int i = 0; i < 4; i++) {
                int ii = arr[1] + v1[i];
                int jj = arr[2] + v2[i];
                int val = arr[0];
                
                if (ii >= 0 && ii < n && jj >= 0 && jj < m) {
                    if (grid[arr[1]][arr[2]] != v3[i]) {
                        val++;
                    }
                    if (vis[ii][jj] > val) {
                        p.add(new int[] { val, ii, jj });
                        vis[ii][jj] = val;
                    }
                }
                
            }
        }
        return -1;
    }

    public int minCost(int[][] grid) {
        return f(grid);
    }
}