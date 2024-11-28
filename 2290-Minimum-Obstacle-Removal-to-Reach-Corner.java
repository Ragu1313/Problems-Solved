class Solution {

    public int f(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        // Priority queue with obstacle count as priority
        PriorityQueue<int[]> p = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        p.add(new int[]{0, 0, 0}); // Start with 0 obstacles removed at (0, 0)

        // Directions for moving: {down, right, up, left}
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // Visited array to track obstacle counts for each cell
        // int[][] visited = new int[n][m];
        // for (int[] row : visited) {
        //     Arrays.fill(row, Integer.MAX_VALUE);
        // }
        // visited[0][0] = 0;

        while (!p.isEmpty()) {
            int[] arr = p.poll();
            int obstacleCount = arr[0], row = arr[1], col = arr[2];

            // If we've reached the bottom-right corner
            if (row == n - 1 && col == m - 1) {
                return obstacleCount;
            }

            // Check all four possible directions
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Skip invalid cells
                if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m || mat[newRow][newCol]==-1) continue;

                // Calculate new obstacle count
                
                int newObstacleCount = obstacleCount  ;
                if(mat[newRow][newCol]==1){
                    newObstacleCount++;
                }

                // Only process if this path has fewer obstacles
                // if (newObstacleCount < visited[newRow][newCol]) {
                    // visited[newRow][newCol] = newObstacleCount;
                    mat[newRow][newCol]=-1;
                    p.add(new int[]{newObstacleCount, newRow, newCol});
                // }
            }
        }

        return -1; // If no path exists
    }

    public int minimumObstacles(int[][] grid) {
        return f(grid);
    }
}
