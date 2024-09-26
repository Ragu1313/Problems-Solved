class Solution {
    boolean res = false;
    int v1[] = new int[]{1, 0, -1, 0};
    int v2[] = new int[]{0, -1, 0, 1};

    public void bfs(int i, int j, int n1, int m1, List<List<Integer>> grid, int visited[][], int health) {
        // Initialize visited with current health
        visited[i][j] = health;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j, health});
        
        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int i1 = arr[0];
            int j1 = arr[1];
            int h = arr[2];
            
            // Check if we reached the bottom-right corner
            if (i1 == n1 - 1 && j1 == m1 - 1) {
                res = true;
                return;
            }
            
            // Explore all 4 directions
            for (int k = 0; k < 4; k++) {
                int n = i1 + v1[k];
                int m = j1 + v2[k];
                
                // Ensure the new position is within bounds
                if (n >= 0 && n < n1 && m >= 0 && m < m1) {
                    int nextHealth = h;
                    
                    // If we encounter an obstacle (grid value = 1), reduce health
                    if (grid.get(n).get(m) == 1) {
                        nextHealth--;
                    }
                    
                    // Ensure the next health is positive and the new path is better (more health left)
                    if (nextHealth > 0 && visited[n][m] < nextHealth) {
                        visited[n][m] = nextHealth;
                        q.add(new int[]{n, m, nextHealth});
                    }
                }
            }
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        int visited[][] = new int[n][m]; // Track the minimum remaining health at each cell
        
        // Initialize visited grid with a very large number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = Integer.MIN_VALUE;
            }
        }
        
        // If the starting point is an obstacle, reduce health
        if (grid.get(0).get(0) == 1) {
            health--;
        }
        
        // If health drops to zero or below, return false
        if (health <= 0) {
            return false;
        }

        // Start BFS
        bfs(0, 0, n, m, grid, visited, health);
        return res;
    }
}
