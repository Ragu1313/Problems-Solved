class Solution {
    public int f(int r, int c, int n, int m, int grid[][]) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        System.out.println();
        grid[r][c] = 0;
        int cnt = 1;
        // int n
        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int rr = arr[0];
            int cc = arr[1];
            // System.out.println(rr + " " + cc);
            // if (rr >= 0 && rr < n && cc >= 0 && cc < m && grid[rr][cc] == 1) {
            // q.add(new int[] { rr, cc });
            // cnt++;
            // grid[rr][cc] = 0;
            for (int i = 0; i < m; i++) {
                if (grid[rr][i] == 1) {
                    cnt++;
                    grid[rr][i] = 0;
                    // System.out.println(rr+" "+i);
                    q.add(new int[] { rr, i });
                }
            }
            for (int j = 0; j < n; j++) {
                if (grid[j][cc] == 1) {
                    cnt++;
                    grid[j][cc] = 0;
                    // System.out.println(j+" "+cc);
                    q.add(new int[] { j, cc });
                }
            }

            // }
        }
        return cnt == 1 ? 0 : cnt;

    }

    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    res += f(i, j, n, m, grid);
                }
            }
        }
        return res;
    }
}