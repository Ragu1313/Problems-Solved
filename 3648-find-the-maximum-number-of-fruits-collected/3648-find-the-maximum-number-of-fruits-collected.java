import java.util.Arrays;

class Solution {
    
    // From top-right to bottom-left
    public int f1(int i, int j, int n, int startCol, int[][] dp, int[][] mat) {
        if (i == n - 1) {
            if (j == n - 1) {
                return mat[i][j];
            }
            return -(int)(1e6); // Invalid path
        }

        if (dp[i][j] != -1) return dp[i][j];

        int res = Integer.MIN_VALUE;

        // Down-left
        if (i + 1 < n && j - 1 >= startCol) {
            res = Math.max(f1(i + 1, j - 1, n, startCol, dp, mat), res);
        }
        // Down
        if (i + 1 < n) {
            res = Math.max(f1(i + 1, j, n, startCol, dp, mat), res);
        }
        // Down-right
        if (j + 1 < n) {
            res = Math.max(f1(i + 1, j + 1, n, startCol, dp, mat), res);
        }

        return dp[i][j] = res + mat[i][j];
    }

    // From bottom-left to top-right
    public int f2(int i, int j, int startRow, int n, int[][] mat, int[][] dp) {
        if (j == n - 1) {
            if (i == n - 1) {
                return mat[i][j];
            }
            return -(int)(1e6); // Invalid path
        }

        if (dp[i][j] != -1) return dp[i][j];

        int res = Integer.MIN_VALUE;

        // Up-right
        if (i - 1 >= startRow && j + 1 < n) {
            res = Math.max(res, f2(i - 1, j + 1, startRow, n, mat, dp));
        }
        // Right
        if (j + 1 < n) {
            res = Math.max(res, f2(i, j + 1, startRow, n, mat, dp));
        }
        // Down-right
        if (i + 1 < n && j + 1 < n) {
            res = Math.max(res, f2(i + 1, j + 1, startRow, n, mat, dp));
        }

        return dp[i][j] = res + mat[i][j];
    }

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int[][] dp = new int[n][n];
        
        // Step 1: Collect main diagonal
        int res = 0;
        int i = 0, j = 0;
        while (i < n) {
            res += fruits[i][j];
            fruits[i][j] = 0; // Mark as visited
            i++; j++;
        }

        // Step 2: From bottom-left to top-right
        for (int[] row : dp) Arrays.fill(row, -1);
        int temp1 = f2(n - 1, 0, n / 2, n, fruits, dp);

        // Step 3: From top-right to bottom-left
        for (int[] row : dp) Arrays.fill(row, -1);
        int temp2 = f1(0, n - 1, n, n / 2, dp, fruits);

        // Optional Debug
        // System.out.println("Diagonal: " + res + ", f2: " + temp1 + ", f1: " + temp2);

        return res + temp1 + temp2;
    }

    // For testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] fruits = {
            {3, 0, 1},
            {2, 5, 0},
            {4, 6, 7}
        };
        int result = sol.maxCollectedFruits(fruits);
        System.out.println("Max Fruits Collected: " + result); // Expected: 15 + path1 + path2
    }
}
