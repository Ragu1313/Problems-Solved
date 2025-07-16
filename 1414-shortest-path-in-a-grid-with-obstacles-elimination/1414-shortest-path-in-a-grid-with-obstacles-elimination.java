class Solution {
    class Pair {
        int cost, k, i, j;

        Pair(int cost, int k, int i, int j) {
            this.cost = cost;
            this.k = k;
            this.i = i;
            this.j = j;
        }
    }

    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[] v1 = {-1, 0, 1, 0};
        int[] v2 = {0, -1, 0, 1};

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> {
            if (a.cost != b.cost) return a.cost - b.cost;
            return b.k - a.k;
        });

        int[][][] vis = new int[n][m][k+1];
        int cnt = 1;
        vis[0][0][k] = 1;

        q.add(new Pair(0, k, 0, 0));

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                Pair temp = q.poll();
                int val = temp.cost;
                int tempk = temp.k;
                int i = temp.i;
                int j = temp.j;

                if (i == n - 1 && j == m - 1) return cnt - 1;

                for (int r = 0; r < 4; r++) {
                    int newi = i + v1[r];
                    int newj = j + v2[r];

                    if (newi >= 0 && newj >= 0 && newi < n && newj < m && vis[newi][newj][tempk] == 0) {
                        if (grid[newi][newj] == 1 && tempk > 0) {
                            vis[newi][newj][tempk] = 1;
                            q.add(new Pair(val + 1, tempk - 1, newi, newj));
                        } else if (grid[newi][newj] == 0) {
                            vis[newi][newj][tempk] = 1;
                            q.add(new Pair(val + 1, tempk, newi, newj));
                        }
                        
                    }
                }
            }
            cnt++;
        }

        return -1;
    }
}
