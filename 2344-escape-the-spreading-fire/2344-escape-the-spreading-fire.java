class Solution {

    public int[][] deepCopyGrid(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone(); // shallow copy is safe for 1D array
        }
        return copy;
    }

    public boolean canReachAfterDelay(int k, int[][] grid, Queue<int[]> fireQueue) {
        int n = grid.length, m = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // Spread fire for 'k' minutes before person starts
        while (k-- > 0 && !fireQueue.isEmpty()) {
            int size = fireQueue.size();
            while (size-- > 0) {
                int[] fire = fireQueue.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int ni = fire[0] + dx[dir], nj = fire[1] + dy[dir];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] != 2 && grid[ni][nj] != 1) {
                        grid[ni][nj] = 1; // burn the cell
                        fireQueue.add(new int[]{ni, nj});
                    }
                }
            }
        }

        // If start is already burning, return false
        if (grid[0][0] == 1) return false;

        // BFS for both person and fire
        Queue<int[]> person = new LinkedList<>();
        person.add(new int[]{0, 0});

        while (!person.isEmpty()) {
            // Spread fire first
            int fireSize = fireQueue.size();
            while (fireSize-- > 0) {
                int[] fire = fireQueue.poll();
                grid[fire[0]][fire[1]] = 1;
                for (int dir = 0; dir < 4; dir++) {
                    int ni = fire[0] + dx[dir], nj = fire[1] + dy[dir];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] != 2 && grid[ni][nj] != 1 && grid[ni][nj] != 4) {
                        grid[ni][nj] = 4; // future fire
                        fireQueue.add(new int[]{ni, nj});
                    }
                }
            }

            int personSize = person.size();
            while (personSize-- > 0) {
                int[] curr = person.poll();
                for (int dir = 0; dir < 4; dir++) {
                    int ni = curr[0] + dx[dir], nj = curr[1] + dy[dir];
                    if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] != 2 && grid[ni][nj] != 1 && grid[ni][nj] != 3) {
                        // if reached destination before fire arrives
                        if (ni == n - 1 && nj == m - 1) return true;

                        if (grid[ni][nj] != 4) {
                            person.add(new int[]{ni, nj});
                        }
                        grid[ni][nj] = 3; // visited
                    }
                }
            }
        }

        return false;
    }

    public int maximumMinutes(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        // Initial fire locations
        Queue<int[]> fireInit = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    fireInit.add(new int[]{i, j});
                }
            }
        }

        int low = 0, high = (int) 1e9, ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Deep copy grid and fire queue for this iteration
            int[][] mat = deepCopyGrid(grid);
            Queue<int[]> fireCopy = new LinkedList<>();
            for (int[] f : fireInit) {
                fireCopy.add(new int[]{f[0], f[1]});
            }

            if (canReachAfterDelay(mid, mat, fireCopy)) {
                ans = mid;
                low = mid + 1; // try to delay even more
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
