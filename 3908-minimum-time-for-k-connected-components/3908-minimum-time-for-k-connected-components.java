

class DSU {
    int[] par;
    int com;

    public DSU(int n) {
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        com = n;
    }

    public int find(int x) {
        if (par[x] != x) {
            par[x] = find(par[x]);
        }
        return par[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            par[pa] = pb;
            com--;
        }
    }
}

class Solution {
    public int minTime(int n, int[][] edges, int k) {
        
        DSU preCheck = new DSU(n);
        for (int[] e : edges) {
            preCheck.union(e[0], e[1]);
        }
        if (preCheck.com >= k) return 0;

        
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));

        int left = 0, right = (int)1e9;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            DSU dsu = new DSU(n);
            for (int[] e : edges) {
                int u = e[0], v = e[1], time = e[2];
                if (time > mid) {
                    dsu.union(u, v);
                }
            }

            if (dsu.com >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
