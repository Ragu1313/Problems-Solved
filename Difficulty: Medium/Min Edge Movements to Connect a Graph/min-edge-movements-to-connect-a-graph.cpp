class DSU {
public:
    int comps;
    vector<int> parent;
    DSU(int n) {
        comps = n;
        parent = vector<int>(n);
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    int par(int n) {
        if (parent[n] == n)
            return n;
        int p = par(parent[n]);
        return parent[n] = p;
    }
    void merge(int a, int b) {
        int p1 = par(a);
        int p2 = par(b);

        if (p1 != p2) {
            comps--;
            parent[p1] = p2;
        }
    }
};

class Solution {
public:
    int minEdgesReq(int n, vector<vector<int>>& edges) {
        if (edges.size() < n - 1)
            return -1;

        DSU* obj = new DSU(n);
        for (auto it : edges)
            obj->merge(it[0], it[1]);

        return obj->comps - 1;
    }
};