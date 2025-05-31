class Solution {

    public int f(int mat[][], Map<Integer, Integer> map) {
        Queue<Integer> q = new LinkedList<>();
        int n = mat.length;
        int vis[] = new int[n * n + 1];
        int des = n * n;

        int start = map.get(1) == -1 ? 1 : map.get(1);
        q.add(start);
        vis[start] = 1;

        int cnt = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == des) return cnt;

                for (int k = 1; k <= 6; k++) {
                    if (cur + k > des) continue;

                    int track = map.get(cur + k);
                    if (track != -1 && vis[track] == 0) {
                        q.add(track);
                        vis[track] = 1;
                    } else if (track == -1 && vis[cur + k] == 0) {
                        q.add(cur + k);
                        vis[cur + k] = 1;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    public int snakesAndLadders(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = board.length;
        int num = 1;
        boolean leftToRight = true;

        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    map.put(num++, board[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    map.put(num++, board[i][j]);
                }
            }
            leftToRight = !leftToRight;
        }

        return f(board, map);
    }
}
